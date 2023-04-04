package team.project.foodsparks.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.CuisineRegion;
import team.project.foodsparks.model.DishType;
import team.project.foodsparks.model.Recipe;

@Service
public interface RecipeService {
    Recipe save(Recipe recipe);

    List<Recipe> getAll(PageRequest pageRequest);

    Optional<Recipe> getById(Long id);

    List<Recipe> getRecipeByCuisineRegion(CuisineRegion cuisineRegion);

    List<Recipe> getByIdLessThan(Long idLimit);

    List<Recipe> findRecipeByDishType(DishType dishType);
}
