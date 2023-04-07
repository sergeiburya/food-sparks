package team.project.foodsparks.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import team.project.foodsparks.dto.response.OrderResponseDto;
import team.project.foodsparks.model.Order;
import team.project.foodsparks.model.ShoppingCart;
import team.project.foodsparks.model.User;
import team.project.foodsparks.service.OrderService;
import team.project.foodsparks.service.ShoppingCartService;
import team.project.foodsparks.service.UserService;
import team.project.foodsparks.service.mapper.ResponseDtoMapper;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {
    private final ShoppingCartService shoppingCartService;
    private final OrderService orderService;
    private final UserService userService;
    private final ResponseDtoMapper<OrderResponseDto, Order> orderResponseDtoMapper;

    public OrderController(ShoppingCartService shoppingCartService,
                           OrderService orderService,
                           UserService userService,
                           ResponseDtoMapper<OrderResponseDto, Order> orderResponseDtoMapper) {
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
        this.userService = userService;
        this.orderResponseDtoMapper = orderResponseDtoMapper;
    }

    @PostMapping("/complete")
    @ApiOperation(value = "Complete Order")
    public OrderResponseDto completeOrder(Authentication auth) {
        String email = auth.getName();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        ShoppingCart cart = shoppingCartService.getByUser(user);
        return orderResponseDtoMapper.mapToDto(orderService.completeOrder(cart));
    }

    @GetMapping
    @ApiOperation(value = "History Orders")
    public List<OrderResponseDto> getOrderHistory(Authentication auth) {
        String email = auth.getName();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        return orderService.getOrders(user)
                .stream()
                .map(orderResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
