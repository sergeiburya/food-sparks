package team.project.foodsparks.service.mapper;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.response.OrderResponseDto;
import team.project.foodsparks.model.Order;

@Component
public class OrderMapper implements ResponseDtoMapper<OrderResponseDto, Order> {
    private final DeliveryInformationMapper deliveryInformationMapper;

    @Autowired
    public OrderMapper(DeliveryInformationMapper deliveryInformationMapper) {
        this.deliveryInformationMapper = deliveryInformationMapper;
    }

    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setUserId(order.getUser().getId());
        responseDto.setOrderTime(order.getOrderTime());
        responseDto.setProductAmount(order.getProductAmount().entrySet()
                .stream()
                .collect(Collectors.toMap(m -> m.getKey().getName(), Map.Entry::getValue)));
        responseDto.setDeliveryInformationResponseDto(deliveryInformationMapper
                .mapToDto(order.getDeliveryInformation()));
        responseDto.setSum(order.getSum());
        return responseDto;
    }
}
