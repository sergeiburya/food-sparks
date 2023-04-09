package team.project.foodsparks.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import team.project.foodsparks.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>,
        JpaSpecificationExecutor<Recipe> {
    List<Recipe> findRecipeByCuisineRegionId(Long cuisineRegionId);

    List<Recipe> findRecipeByDishTypeId(Long dishTypeId);

    List<Recipe> getByIdLessThanEqual(Long idLimit);
}
