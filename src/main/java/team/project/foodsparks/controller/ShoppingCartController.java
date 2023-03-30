package team.project.foodsparks.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import team.project.foodsparks.dto.response.ShoppingCartResponseDto;
import team.project.foodsparks.model.User;
import team.project.foodsparks.service.ShoppingCartService;
import team.project.foodsparks.service.UserService;
import team.project.foodsparks.service.mapper.ShoppingCartMapper;

@RestController
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final ShoppingCartMapper shoppingCartMapper;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @GetMapping("/shopping_card")
    @ApiOperation(value = "User Shopping Card")
    public ShoppingCartResponseDto getByUser(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        return shoppingCartMapper.mapToDto(shoppingCartService.getByUser(user));
    }
}