package team.project.foodsparks.service;

import team.project.foodsparks.model.ShoppingCart;
import team.project.foodsparks.model.User;

public interface ShoppingCartService {

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    ShoppingCart clear(ShoppingCart shoppingCart);

    ShoppingCart increaseProductAmount(Long productId, User user);

    ShoppingCart decreaseProductAmount(Long productId, User user);

    ShoppingCart removeProductFromCart(Long productId, User user);

    ShoppingCart removeAllProductsFromCart(User user);

    ShoppingCart setCoupon(User user, String couponValue);
}
