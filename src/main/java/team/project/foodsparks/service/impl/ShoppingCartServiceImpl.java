package team.project.foodsparks.service.impl;

import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.foodsparks.exception.DataProcessingException;
import team.project.foodsparks.model.Coupon;
import team.project.foodsparks.model.Product;
import team.project.foodsparks.model.ShoppingCart;
import team.project.foodsparks.model.User;
import team.project.foodsparks.model.Warehouse;
import team.project.foodsparks.repository.ShoppingCartRepository;
import team.project.foodsparks.repository.WarehouseRepository;
import team.project.foodsparks.service.CouponService;
import team.project.foodsparks.service.ProductService;
import team.project.foodsparks.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final WarehouseRepository warehouseRepository;
    private final ProductService productService;
    private final CouponService couponService;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   WarehouseRepository warehouseRepository,
                                   ProductService productService,
                                   CouponService couponService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.warehouseRepository = warehouseRepository;
        this.productService = productService;
        this.couponService = couponService;
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartRepository.getById(user.getId());
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart clear(ShoppingCart shoppingCart) {
        shoppingCart.getProductAmount().clear();
        shoppingCart.setCoupon(null);
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    @Transactional
    public ShoppingCart increaseProductAmount(Long productId, User user) {
        Warehouse warehouseProduct = warehouseRepository.getById(productId);
        Integer warehouseProductAmount = warehouseProduct.getAmount();
        if (warehouseProductAmount < 1) {
            throw new RuntimeException("Немає необхідної кількості продукту в наявності : "
                    + warehouseProduct.getProduct().getName());
        }
        warehouseProduct.setAmount(warehouseProductAmount - 1);
        warehouseRepository.save(warehouseProduct);
        ShoppingCart shoppingCart = getByUser(user);
        Product product = productService.getById(productId).get();
        Map<Product, Integer> productAmount = shoppingCart.getProductAmount();
        if (productAmount.containsKey(product)) {
            productAmount.put(product, productAmount.get(product) + 1);
        } else {
            productAmount.put(product, 1);
        }
        shoppingCartRepository.save(shoppingCart);
        return shoppingCart;
    }

    @Override
    @Transactional
    public ShoppingCart decreaseProductAmount(Long productId, User user) {
        ShoppingCart shoppingCart = getByUser(user);
        Product product = productService.getById(productId).get();
        Map<Product, Integer> productAmount = shoppingCart.getProductAmount();
        Integer currentProductAmount;
        if (productAmount.containsKey(product)) {
            currentProductAmount = productAmount.get(product);
            if (currentProductAmount <= 1) {
                productAmount.remove(product);
            } else {
                productAmount.put(product, productAmount.get(product) - 1);
            }
            shoppingCartRepository.save(shoppingCart);
            Warehouse warehouseProduct = warehouseRepository.getById(productId);
            Integer warehouseProductAmount = warehouseProduct.getAmount();
            warehouseProduct.setAmount(warehouseProductAmount + 1);
            warehouseRepository.save(warehouseProduct);
        }
        return shoppingCart;
    }

    @Override
    @Transactional
    public ShoppingCart removeProductFromCart(Long productId, User user) {
        ShoppingCart shoppingCart = getByUser(user);
        Product product = productService.getById(productId).get();
        Map<Product, Integer> productAmount = shoppingCart.getProductAmount();
        if (productAmount.containsKey(product)) {
            Warehouse warehouseProduct = warehouseRepository.getById(productId);
            Integer warehouseProductAmount = warehouseProduct.getAmount();
            warehouseProduct.setAmount(warehouseProductAmount + productAmount.get(product));
            warehouseRepository.save(warehouseProduct);
            productAmount.remove(product);
            shoppingCartRepository.save(shoppingCart);
        }
        return shoppingCart;
    }

    public ShoppingCart removeAllProductsFromCart(User user) {
        ShoppingCart shoppingCart = getByUser(user);
        Map<Product, Integer> productAmount = shoppingCart.getProductAmount();
        for (Map.Entry<Product, Integer> productIntegerEntry : productAmount.entrySet()) {
            Warehouse byProductId
                    = warehouseRepository.getById(productIntegerEntry.getKey().getId());
            byProductId.setAmount(byProductId.getAmount() + productIntegerEntry.getValue());
            warehouseRepository.save(byProductId);
        }
        return this.clear(shoppingCart);
    }

    @Override
    public ShoppingCart setCoupon(User user, String couponValue) {
        Coupon coupon = couponService.getByValue(couponValue).orElseThrow(
                () -> new DataProcessingException("Купон: " + couponValue + " не існує.")
        );
        if (coupon.isExpired() || !coupon.getUserEmail().equals(user.getEmail())) {
            throw new DataProcessingException("Недійсний купон");
        }
        ShoppingCart cartByUser = getByUser(user);
        cartByUser.setCoupon(coupon);
        return shoppingCartRepository.save(cartByUser);
    }
}
