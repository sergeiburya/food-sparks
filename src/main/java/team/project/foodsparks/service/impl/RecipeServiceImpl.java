package team.project.foodsparks.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.Complexity;
import team.project.foodsparks.model.Recipe;
import team.project.foodsparks.repository.RecipeRepository;
import team.project.foodsparks.repository.specification.SpecificationManager;
import team.project.foodsparks.service.ComplexityService;
import team.project.foodsparks.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final ComplexityService complexityService;
    private final SpecificationManager<Recipe> recipeSpecificationManager;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository,
                             ComplexityService complexityService,
                             SpecificationManager<Recipe> recipeSpecificationManager) {
        this.recipeRepository = recipeRepository;
        this.complexityService = complexityService;
        this.recipeSpecificationManager = recipeSpecificationManager;
    }

    @Override
    public Recipe save(Recipe recipe) {
        Integer cookingTime = recipe.getCookingTime();
        Complexity.ComplexityName complexityName = cookingTime > 60
                ? Complexity.ComplexityName.HARD : cookingTime > 30
                ? Complexity.ComplexityName.MEDIUM : Complexity.ComplexityName.EASY;
        Complexity complexity = complexityService.getByName(complexityName).get();
        recipe.setComplexity(complexity);
        return recipeRepository.save(recipe);
    }

    @Override
    public Page<Recipe> findAll(Map<String, String> params,
                                PageRequest pageRequest) {
        Specification<Recipe> specification = null;
        for (Map.Entry<String,String> entry : params.entrySet()) {
            Specification<Recipe> sp = recipeSpecificationManager.get(entry.getKey(),
                    entry.getValue().split(","));
            specification = specification == null
                    ? Specification.where(sp) : specification.and(sp);
        }
        return recipeRepository.findAll(specification, pageRequest);
    }

    @Override
    public Optional<Recipe> getById(Long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public List<Recipe> findByNameContains(String letters) {
        return recipeRepository.findRecipeByTitleContainsIgnoreCase(letters);
    }
}
