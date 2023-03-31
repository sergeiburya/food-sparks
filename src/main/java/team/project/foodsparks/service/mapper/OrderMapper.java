package team.project.foodsparks.service.mapper;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.response.OrderResponseDto;
import team.project.foodsparks.model.Ingredient;
import team.project.foodsparks.model.Order;

@Component
public class OrderMapper implements ResponseDtoMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setUserId(order.getUser().getId());
        responseDto.setOrderTime(order.getOrderTime());
        responseDto.setIngredientIds(order.getIngredients()
                .stream()
                .map(Ingredient::getId)
                .collect(Collectors.toList()));
        return responseDto;
    }
}
