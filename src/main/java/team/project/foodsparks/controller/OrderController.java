package team.project.foodsparks.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.project.foodsparks.dto.request.DeliveryInformationRequestDto;
import team.project.foodsparks.dto.response.OrderResponseDto;
import team.project.foodsparks.exception.DataProcessingException;
import team.project.foodsparks.model.DeliveryInformation;
import team.project.foodsparks.model.Order;
import team.project.foodsparks.model.ShoppingCart;
import team.project.foodsparks.model.User;
import team.project.foodsparks.service.OrderService;
import team.project.foodsparks.service.ShoppingCartService;
import team.project.foodsparks.service.UserService;
import team.project.foodsparks.service.mapper.RequestDtoMapper;
import team.project.foodsparks.service.mapper.ResponseDtoMapper;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {
    private final ShoppingCartService shoppingCartService;
    private final OrderService orderService;
    private final UserService userService;
    private final ResponseDtoMapper<OrderResponseDto, Order> orderResponseDtoMapper;
    private final RequestDtoMapper<DeliveryInformationRequestDto, DeliveryInformation>
            deliveryInformationRequestDtoMapper;

    public OrderController(ShoppingCartService shoppingCartService,
                           OrderService orderService,
                           UserService userService,
                           ResponseDtoMapper<OrderResponseDto, Order> orderResponseDtoMapper,
                           RequestDtoMapper<DeliveryInformationRequestDto, DeliveryInformation>
                                   deliveryInformationMapper) {
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
        this.userService = userService;
        this.orderResponseDtoMapper = orderResponseDtoMapper;
        this.deliveryInformationRequestDtoMapper = deliveryInformationMapper;
    }

    @PostMapping("/complete")
    @ApiOperation(value = "Complete Order. All products with quantity will be moved to order."
            + " Shopping cart will be cleared."
    )
    public OrderResponseDto completeOrder(Authentication auth,
                                          @RequestBody DeliveryInformationRequestDto dto) {
        String email = auth.getName();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new DataProcessingException("Юзера з імейлом: " + email + " не існує."));
        ShoppingCart cart = shoppingCartService.getByUser(user);
        DeliveryInformation deliveryInformation
                = deliveryInformationRequestDtoMapper.mapToModel(dto);
        return orderResponseDtoMapper.mapToDto(orderService
                .completeOrder(cart, deliveryInformation));
    }

    @GetMapping
    @ApiOperation(value = "Get order history of current authenticated user")
    public List<OrderResponseDto> getOrderHistory(Authentication auth) {
        String email = auth.getName();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new DataProcessingException("Юзера з імейлом: " + email + " не існує."));
        return orderService.getOrders(user)
                .stream()
                .map(orderResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
