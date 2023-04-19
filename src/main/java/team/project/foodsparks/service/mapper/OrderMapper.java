package team.project.foodsparks.service.mapper;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.request.OrderRequestDto;
import team.project.foodsparks.dto.response.OrderResponseDto;
import team.project.foodsparks.model.Order;

@Component
public class OrderMapper implements ResponseDtoMapper<OrderResponseDto, Order>,
        RequestDtoMapper<OrderRequestDto, Order> {
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

    @Override
    public Order mapToModel(OrderRequestDto dto) {
        Order order = new Order();
        order.setComment(dto.getComment());
        order.setDayOfDelivery(dto.getDayOfDelivery());
        order.setTimeOfDelivery(dto.getTimeOfDelivery());
        return order;
    }
}
