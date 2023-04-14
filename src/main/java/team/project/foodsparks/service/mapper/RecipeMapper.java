package team.project.foodsparks.service.mapper;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.request.RecipeRequestDto;
import team.project.foodsparks.dto.response.ProductResponseDto;
import team.project.foodsparks.dto.response.RecipeResponseDto;
import team.project.foodsparks.model.Product;
import team.project.foodsparks.model.Recipe;
import team.project.foodsparks.service.CuisineRegionService;
import team.project.foodsparks.service.DishTypeService;
import team.project.foodsparks.service.ProductService;
import team.project.foodsparks.util.CookingTimeConverter;

@Component
public class RecipeMapper implements RequestDtoMapper<RecipeRequestDto, Recipe>,
        ResponseDtoMapper<RecipeResponseDto, Recipe> {

    private final ProductService productService;
    private final CuisineRegionService cuisineRegionService;
    private final DishTypeService dishTypeService;
    private final ResponseDtoMapper<ProductResponseDto, Product> productMapper;

    @Autowired
    public RecipeMapper(ProductService productService,
                        CuisineRegionService cuisineRegionService,
                        DishTypeService dishTypeService,
                        ResponseDtoMapper<ProductResponseDto, Product> productMapper) {
        this.productService = productService;
        this.cuisineRegionService = cuisineRegionService;
        this.dishTypeService = dishTypeService;
        this.productMapper = productMapper;
    }

    @Override
    public Recipe mapToModel(RecipeRequestDto dto) {
        Recipe recipe = new Recipe();
        recipe.setCuisineRegion(cuisineRegionService.getById(dto.getCuisineRegionId()).get());
        recipe.setDishType(dishTypeService.getById(dto.getDishTypeId()).get());
        recipe.setTitle(dto.getTitle());
        recipe.setSubtitle(dto.getSubtitle());
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
        recipeResponseDto.setTitle(recipe.getTitle());
        recipeResponseDto.setCuisineRegion(recipe.getCuisineRegion().getCuisineRegionName()
                .toString());
        recipeResponseDto.setDishType(recipe.getDishType().getDishTypeName().toString());
        recipeResponseDto.setSpiced(recipe.isSpiced());
        recipeResponseDto.setInstructions(recipe.getInstructions());
        recipeResponseDto.setProductsList(recipe.getProductList().entrySet()
                .stream()
                .collect(Collectors.toMap(e
                        -> productMapper.mapToDto(e.getKey()), Map.Entry::getValue)));
        recipeResponseDto.setPortions(recipe.getPortions());
        recipeResponseDto.setCookingTime(CookingTimeConverter
                .convertCookingTime(recipe.getCookingTime()));
        recipeResponseDto.setImageUrl(recipe.getImageUrl());
        recipeResponseDto.setSubtitle(recipe.getSubtitle());
        recipeResponseDto.setComplexity(recipe.getComplexity().getComplexityName().toString());
        return recipeResponseDto;
    }
}
