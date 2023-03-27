package team.project.foodsparks.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.project.foodsparks.model.CuisineRegion;
import team.project.foodsparks.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findRecipeByCuisineRegion(CuisineRegion cuisineRegion);
}
