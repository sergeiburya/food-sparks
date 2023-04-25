package team.project.foodsparks.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.foodsparks.exception.DataProcessingException;
import team.project.foodsparks.model.CartItem;
import team.project.foodsparks.model.Coupon;
import team.project.foodsparks.model.Product;
import team.project.foodsparks.model.ShoppingCart;
import team.project.foodsparks.model.User;
import team.project.foodsparks.model.Warehouse;
import team.project.foodsparks.repository.ShoppingCartRepository;
import team.project.foodsparks.repository.WarehouseRepository;
import team.project.foodsparks.service.CartItemService;
import team.project.foodsparks.service.CouponService;
import team.project.foodsparks.service.ProductService;
import team.project.foodsparks.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final WarehouseRepository warehouseRepository;
    private final CartItemService cartItemService;
    private final ProductService productService;
    private final CouponService couponService;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   WarehouseRepository warehouseRepository,
                                   CartItemService cartItemService,
                                   ProductService productService,
                                   CouponService couponService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.warehouseRepository = warehouseRepository;
        this.cartItemService = cartItemService;
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
        List<CartItem> cartItemList = shoppingCart.getCartItemList();
        for (CartItem cartItem : cartItemList) {
            if (cartItem.getProduct().equals(product)) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                return shoppingCartRepository.save(shoppingCart);
            }
        }
        CartItem newCartItem = new CartItem();
        newCartItem.setProduct(product);
        newCartItem.setQuantity(1);
        cartItemList.add(newCartItem);
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    @Transactional
    public ShoppingCart decreaseProductAmount(Long productId, User user) {
        ShoppingCart shoppingCart = getByUser(user);
        Product product = productService.getById(productId).get();
        List<CartItem> cartItemList = shoppingCart.getCartItemList();
        Integer currentProductAmount;
        for (CartItem cartItem : cartItemList) {
            if (cartItem.getProduct().equals(product)) {
                currentProductAmount = cartItem.getQuantity();
                if (currentProductAmount <= 1) {
                    cartItemService.delete(cartItem);
                    cartItemList.remove(cartItem);
                    break;
                }
                cartItem.setQuantity(currentProductAmount - 1);
                break;
            }
        }
        shoppingCartRepository.save(shoppingCart);
        Warehouse warehouseProduct = warehouseRepository.getById(productId);
        Integer warehouseProductAmount = warehouseProduct.getAmount();
        warehouseProduct.setAmount(warehouseProductAmount + 1);
        warehouseRepository.save(warehouseProduct);
        return shoppingCart;
    }

    @Override
    @Transactional
    public ShoppingCart removeProductFromCart(Long productId, User user) {
        ShoppingCart shoppingCart = getByUser(user);
        Product product = productService.getById(productId).get();
        List<CartItem> cartItemList = shoppingCart.getCartItemList();
        for (CartItem cartItem : cartItemList) {
            if (cartItem.getProduct().equals(product)) {
                Warehouse warehouseProduct = warehouseRepository.getById(productId);
                Integer warehouseProductAmount = warehouseProduct.getAmount();
                warehouseProduct.setAmount(warehouseProductAmount + cartItem.getQuantity());
                warehouseRepository.save(warehouseProduct);
                cartItemService.delete(cartItem);
                cartItemList.remove(cartItem);
                break;
            }
        }
        return shoppingCartRepository.save(shoppingCart);
    }

    @Transactional
    public ShoppingCart removeAllProductsFromCart(User user) {
        ShoppingCart shoppingCart = getByUser(user);
        List<CartItem> cartItemList = shoppingCart.getCartItemList();
        for (CartItem cartItem : cartItemList) {
            Warehouse byProductId = warehouseRepository.getById(cartItem.getProduct().getId());
            byProductId.setAmount(byProductId.getAmount() + cartItem.getQuantity());
            warehouseRepository.save(byProductId);
            cartItemService.delete(cartItem);
        }
        cartItemList.clear();
        return shoppingCartRepository.save(shoppingCart);
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
