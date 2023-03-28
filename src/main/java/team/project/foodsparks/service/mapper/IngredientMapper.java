package team.project.foodsparks.service.mapper;

import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.request.IngredientRequestDto;
import team.project.foodsparks.dto.response.IngredientResponseDto;
import team.project.foodsparks.model.Ingredient;

@Component
public class IngredientMapper implements RequestDtoMapper<IngredientRequestDto, Ingredient>,
        ResponseDtoMapper<IngredientResponseDto, Ingredient> {
    @Override
    public Ingredient mapToModel(IngredientRequestDto dto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(dto.getIngredientName());
        return ingredient;
    }

    @Override
    public IngredientResponseDto mapToDto(Ingredient ingredient) {
        IngredientResponseDto ingredientResponseDto = new IngredientResponseDto();
        ingredientResponseDto.setId(ingredient.getId());
        ingredientResponseDto.setIngredientName(ingredient.getName());
        return ingredientResponseDto;
    }
}
