package team.project.foodsparks.service.mapper;

import java.math.BigDecimal;
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
        responseDto.setProductAmount(shoppingCart.getCartItemList());
        responseDto.setSum(shoppingCart.getCartItemList()
                .stream()
                .map(e -> e.getProduct().getPrice().multiply(BigDecimal.valueOf(e.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .divide(BigDecimal.valueOf(100))
                .multiply(BigDecimal.valueOf(shoppingCart.getCoupon() != null
                        ? 100 - shoppingCart.getCoupon().getDiscountSize() : 100)));
        return responseDto;
    }
}
