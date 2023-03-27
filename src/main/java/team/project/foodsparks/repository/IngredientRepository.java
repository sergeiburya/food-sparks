package team.project.foodsparks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.project.foodsparks.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
