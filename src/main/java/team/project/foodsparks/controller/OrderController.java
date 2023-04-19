package team.project.foodsparks.controller;

import com.lowagie.text.DocumentException;
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
import team.project.foodsparks.dto.request.OrderRequestDto;
import team.project.foodsparks.dto.response.OrderResponseDto;
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
    private final RequestDtoMapper<OrderRequestDto, Order> orderRequestDtoMapper;

    public OrderController(ShoppingCartService shoppingCartService,
                           OrderService orderService,
                           UserService userService,
                           ResponseDtoMapper<OrderResponseDto, Order> orderResponseDtoMapper,
                           RequestDtoMapper<OrderRequestDto, Order> orderRequestDtoMapper) {
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
        this.userService = userService;
        this.orderResponseDtoMapper = orderResponseDtoMapper;
        this.orderRequestDtoMapper = orderRequestDtoMapper;
    }

    @PostMapping("/complete")
    @ApiOperation(value = "Complete Order. All products with quantity will be moved to order."
            + " Shopping cart will be cleared."
    )
    public OrderResponseDto completeOrder(Authentication auth,
                                          @RequestBody OrderRequestDto orderRequestDto)
            throws DocumentException {
        String email = auth.getName();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        ShoppingCart cart = shoppingCartService.getByUser(user);
        Order order = orderRequestDtoMapper.mapToModel(orderRequestDto);
        return orderResponseDtoMapper.mapToDto(orderService.completeOrder(cart, order));
    }

    @GetMapping
    @ApiOperation(value = "Get order history of current authenticated user")
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
