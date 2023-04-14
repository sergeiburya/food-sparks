package team.project.foodsparks.service.impl;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.Product;
import team.project.foodsparks.model.ShoppingCart;
import team.project.foodsparks.model.User;
import team.project.foodsparks.repository.ShoppingCartRepository;
import team.project.foodsparks.service.ProductService;
import team.project.foodsparks.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductService productService;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   ProductService productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productService = productService;
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
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.getProductAmount().clear();
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart increaseProductAmount(Long productId, User user) {
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
        }
        return shoppingCart;
    }

    @Override
    public ShoppingCart removeProductFromCart(Long productId, User user) {
        ShoppingCart shoppingCart = getByUser(user);
        Product product = productService.getById(productId).get();
        Map<Product, Integer> productAmount = shoppingCart.getProductAmount();
        if (productAmount.containsKey(product)) {
            productAmount.remove(product);
            shoppingCartRepository.save(shoppingCart);
        }
        return shoppingCart;
    }
}
