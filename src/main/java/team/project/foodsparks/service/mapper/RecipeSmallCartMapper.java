package team.project.foodsparks.service.mapper;

import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.response.RecipeSmallCartResponseDto;
import team.project.foodsparks.model.Recipe;
import team.project.foodsparks.util.CookingTimeConverter;

@Component
public class RecipeSmallCartMapper
        implements ResponseDtoMapper<RecipeSmallCartResponseDto, Recipe> {

    @Override
    public RecipeSmallCartResponseDto mapToDto(Recipe recipe) {
        RecipeSmallCartResponseDto dto = new RecipeSmallCartResponseDto();
        dto.setId(recipe.getId());
        dto.setTitle(recipe.getTitle());
        dto.setImageUrl(recipe.getImageUrl());
        dto.setPortions(recipe.getPortions());
        dto.setDishType(recipe.getDishType().getDishTypeName().toString());
        dto.setCookingTime(CookingTimeConverter.convertCookingTime(recipe.getCookingTime()));
        return dto;
    }
}
