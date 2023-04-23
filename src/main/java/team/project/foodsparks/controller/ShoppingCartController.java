package team.project.foodsparks.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.project.foodsparks.dto.response.ShoppingCartResponseDto;
import team.project.foodsparks.exception.DataProcessingException;
import team.project.foodsparks.model.ShoppingCart;
import team.project.foodsparks.model.User;
import team.project.foodsparks.service.ShoppingCartService;
import team.project.foodsparks.service.UserService;
import team.project.foodsparks.service.mapper.ResponseDtoMapper;
import team.project.foodsparks.service.mapper.ShoppingCartMapper;

@RestController
@RequestMapping("/shopping-cart")
@CrossOrigin(origins = "*")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final ResponseDtoMapper<ShoppingCartResponseDto, ShoppingCart> shoppingCartMapper;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @GetMapping
    @ApiOperation(value = "User Shopping Card by current authenticated user")
    public ShoppingCartResponseDto getByUser(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new DataProcessingException("Користувача з імейлом: "
                        + email + " не існує."));
        return shoppingCartMapper.mapToDto(shoppingCartService.getByUser(user));
    }

    @PutMapping("/increase")
    @ApiOperation(value = "Increase product quantity in to "
            + "shopping cart of current authenticated user")
    public ShoppingCartResponseDto increaseProductAmount(Authentication auth,
                                                         @RequestParam Long productId) {

        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new DataProcessingException("Користувача з імейлом: "
                        + email + " не існує."));
        return shoppingCartMapper
                .mapToDto(shoppingCartService.increaseProductAmount(productId, user));
    }

    @PutMapping("/decrease")
    @ApiOperation(value = "Decrease product quantity in to "
            + "shopping cart of current authenticated user")
    public ShoppingCartResponseDto decreaseProductAmount(Authentication auth,
                                                         @RequestParam Long productId) {

        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new DataProcessingException("Користувача з імейлом: "
                        + email + " не існує."));
        return shoppingCartMapper
                .mapToDto(shoppingCartService.decreaseProductAmount(productId, user));
    }

    @PutMapping("/remove")
    @ApiOperation(value = "Remove product from shopping cart of current authenticated user")
    public ShoppingCartResponseDto removeProduct(Authentication auth,
                                                 @RequestParam Long productId) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new DataProcessingException("Користувача з імейлом: "
                        + email + " не існує."));
        return shoppingCartMapper
                .mapToDto(shoppingCartService.removeProductFromCart(productId, user));

    }

    @PutMapping("/clear")
    @ApiOperation(value = "Remove product from shopping cart of current authenticated user")
    public ShoppingCartResponseDto removeProduct(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new DataProcessingException("Користувача з імейлом: "
                        + email + " не існує."));
        return shoppingCartMapper
                .mapToDto(shoppingCartService.removeAllProductsFromCart(user));

    }

    @PutMapping("/addCoupon")
    public ShoppingCartResponseDto addCoupon(Authentication auth,
                                             @RequestParam String couponValue) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new DataProcessingException("Користувача з імейлом: "
                        + email + " не існує."));
        return shoppingCartMapper.mapToDto(shoppingCartService.setCoupon(user, couponValue));
    }
}
