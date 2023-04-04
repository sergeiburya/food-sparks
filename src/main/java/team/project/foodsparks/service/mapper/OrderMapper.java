package team.project.foodsparks.service.mapper;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.response.OrderResponseDto;
import team.project.foodsparks.model.Order;

@Component
public class OrderMapper implements ResponseDtoMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setUserId(order.getUser().getId());
        responseDto.setOrderTime(order.getOrderTime());
        responseDto.setProductAmount(order.getProductAmount().entrySet()
                .stream()
                .collect(Collectors.toMap(m -> m.getKey().getName(), Map.Entry::getValue)));
        return responseDto;
    }
}
