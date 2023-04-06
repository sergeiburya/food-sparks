package team.project.foodsparks.service.mapper;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.request.RecipeRequestDto;
import team.project.foodsparks.dto.response.RecipeResponseDto;
import team.project.foodsparks.model.Recipe;
import team.project.foodsparks.service.ProductService;
import team.project.foodsparks.util.CookingTimeConverter;

@Component
public class RecipeMapper implements RequestDtoMapper<RecipeRequestDto, Recipe>,
        ResponseDtoMapper<RecipeResponseDto, Recipe> {

    private final ProductService productService;

    public RecipeMapper(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Recipe mapToModel(RecipeRequestDto dto) {
        Recipe recipe = new Recipe();
        recipe.setCuisineRegion(dto.getCuisineRegion());
        recipe.setDishName(dto.getDishName());
        recipe.setSpiced(dto.isSpiced());
        recipe.setInstructions(dto.getInstructions());
        recipe.setProductList(dto.getProductList().entrySet()
                .stream()
                .collect(Collectors.toMap(m -> productService.getById(m.getKey()).get(),
                        Map.Entry::getValue)));
        recipe.setPortions(dto.getPortions());
        recipe.setCookingTime(dto.getCookingTime());
        recipe.setImageUrl(dto.getImageUrl());
        return recipe;
    }

    @Override
    public RecipeResponseDto mapToDto(Recipe recipe) {
        RecipeResponseDto recipeResponseDto = new RecipeResponseDto();
        recipeResponseDto.setId(recipe.getId());
        recipeResponseDto.setDishName(recipe.getDishName());
        recipeResponseDto.setCuisineRegion(recipe.getCuisineRegion().toString());
        recipeResponseDto.setDishType(recipe.getDishType().toString());
        recipeResponseDto.setSpiced(recipe.isSpiced());
        recipeResponseDto.setInstructions(recipe.getInstructions());
        recipeResponseDto.setProductsList(recipe.getProductList());
        recipeResponseDto.setPortions(recipe.getPortions());
        recipeResponseDto.setCookingTime(CookingTimeConverter
                .convertCookingTime(recipe.getCookingTime()));
        recipeResponseDto.setImageUrl(recipe.getImageUrl());
        return recipeResponseDto;
    }
}
