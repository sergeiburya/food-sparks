package team.project.foodsparks.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import team.project.foodsparks.model.Ingredient;
import team.project.foodsparks.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByIngredientTagContains(Ingredient ingredient);
}
