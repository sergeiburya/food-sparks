package team.project.foodsparks.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.Recipe;

@Service
public interface RecipeService {
    Recipe save(Recipe recipe);

    List<Recipe> findAll(Map<String,String> params,
                         PageRequest pageRequest);

    Optional<Recipe> getById(Long id);

    List<Recipe> findRecipeByCuisineRegionId(Long cuisineRegionId);

    List<Recipe> getByIdLessThan(Long idLimit);

    List<Recipe> findRecipeByDishTypeId(Long dishTypeId);
}
