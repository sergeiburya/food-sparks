package team.project.foodsparks.service.mapper;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.request.RecipeRequestDto;
import team.project.foodsparks.dto.response.RecipeResponseDto;
import team.project.foodsparks.model.Recipe;
import team.project.foodsparks.service.IngredientService;

@Component
public class RecipeMapper implements RequestDtoMapper<RecipeRequestDto, Recipe>,
        ResponseDtoMapper<RecipeResponseDto, Recipe> {
    private final IngredientService ingredientService;

    @Autowired
    public RecipeMapper(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Override
    public Recipe mapToModel(RecipeRequestDto dto) {
        Recipe recipe = new Recipe();
        recipe.setCuisineRegion(dto.getCuisineRegion());
        recipe.setDishName(dto.getDishName());
        recipe.setSpiced(dto.isSpiced());
        recipe.setInstructions(dto.getInstructions());
        recipe.setIngredientList(dto.getIngredientList().entrySet()
                .stream()
                .collect(Collectors.toMap(m -> ingredientService.getById(m.getKey()).get(),
                        Map.Entry::getValue)));
        return recipe;
    }

    @Override
    public RecipeResponseDto mapToDto(Recipe recipe) {
        RecipeResponseDto recipeResponseDto = new RecipeResponseDto();
        recipeResponseDto.setId(recipe.getId());
        recipeResponseDto.setDishName(recipe.getDishName());
        recipeResponseDto.setCuisineRegion(recipe.getCuisineRegion());
        recipeResponseDto.setSpiced(recipe.isSpiced());
        recipeResponseDto.setInstructions(recipe.getInstructions());
        recipeResponseDto.setIngredientList(recipe.getIngredientList().entrySet()
                .stream()
                .collect(Collectors.toMap(m -> m.getKey().getName(), Map.Entry::getValue)));
        return recipeResponseDto;
    }
}
