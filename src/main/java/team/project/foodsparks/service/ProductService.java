package team.project.foodsparks.service;

import java.util.List;
import java.util.Optional;
import team.project.foodsparks.model.Ingredient;
import team.project.foodsparks.model.Product;

public interface ProductService {
    Product add(Product product);

    Optional<Product> getById(Long id);

    List<Product> getAll();

    List<Product> getByIngredientTag(Ingredient ingredient);
}
