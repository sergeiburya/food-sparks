package team.project.foodsparks.service;

import java.util.Optional;
import team.project.foodsparks.model.ShoppingCart;

public interface ShoppingCartService {
    ShoppingCart add(ShoppingCart shoppingCart);

    Optional<ShoppingCart> get(Long id);
}
