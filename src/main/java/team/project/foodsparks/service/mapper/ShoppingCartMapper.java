package team.project.foodsparks.service.mapper;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.response.ShoppingCartResponseDto;
import team.project.foodsparks.model.ShoppingCart;

@Component
public class ShoppingCartMapper implements
        ResponseDtoMapper<ShoppingCartResponseDto, ShoppingCart> {

    @Override
    public ShoppingCartResponseDto mapToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setUserId(shoppingCart.getUser().getId());
        responseDto.setProductAmount(shoppingCart.getProductAmount()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(m -> m.getKey().getName(), Map.Entry::getValue)));
        return responseDto;
    }
}
