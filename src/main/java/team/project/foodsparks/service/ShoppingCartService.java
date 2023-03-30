package team.project.foodsparks.service;

import team.project.foodsparks.model.ShoppingCart;
import team.project.foodsparks.model.User;

public interface ShoppingCartService {

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
