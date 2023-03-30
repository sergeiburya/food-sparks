package team.project.foodsparks.service.mapper;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.response.ShoppingCartResponseDto;
import team.project.foodsparks.model.Ingredient;
import team.project.foodsparks.model.ShoppingCart;

@Component
public class ShoppingCartMapper implements
        ResponseDtoMapper<ShoppingCartResponseDto, ShoppingCart> {

    @Override
    public ShoppingCartResponseDto mapToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setUserId(shoppingCart.getUser().getId());
        responseDto.setIngredientId(shoppingCart.getIngredients()
                .stream()
                .map(Ingredient::getId)
                .collect(Collectors.toList()));
        return responseDto;
    }
}
