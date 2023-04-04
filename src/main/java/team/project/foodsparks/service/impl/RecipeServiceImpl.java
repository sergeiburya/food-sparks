package team.project.foodsparks.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.CuisineRegion;
import team.project.foodsparks.model.DishType;
import team.project.foodsparks.model.Recipe;
import team.project.foodsparks.repository.RecipeRepository;
import team.project.foodsparks.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> getAll(PageRequest pageRequest) {
        return recipeRepository.findAll(pageRequest).toList();
    }

    @Override
    public Optional<Recipe> getById(Long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public List<Recipe> getRecipeByCuisineRegion(CuisineRegion cuisineRegion) {
        return recipeRepository.findRecipeByCuisineRegion(cuisineRegion);
    }

    @Override
    public List<Recipe> getByIdLessThan(Long idLimit) {
        return recipeRepository.getByIdLessThanEqual(idLimit);
    }

    @Override
    public List<Recipe> findRecipeByDishType(DishType dishType) {
        return recipeRepository.findRecipeByDishType(dishType);
    }
}
