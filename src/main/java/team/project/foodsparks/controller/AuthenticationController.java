package team.project.foodsparks.controller;

import io.swagger.annotations.ApiOperation;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import team.project.foodsparks.dto.UserLoginDto;
import team.project.foodsparks.dto.UserRegistrationDto;
import team.project.foodsparks.dto.response.UserResponseDto;
import team.project.foodsparks.exeption.AuthenticationException;
import team.project.foodsparks.model.User;
import team.project.foodsparks.security.JwtTokenProvider;
import team.project.foodsparks.service.AuthenticationService;
import team.project.foodsparks.service.mapper.UserMapper;

@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final UserMapper userMapper;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthenticationController(AuthenticationService authService,
                                    UserMapper userMapper,
                                    JwtTokenProvider jwtTokenProvider) {
        this.authService = authService;
        this.userMapper = userMapper;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    @ApiOperation(value = "User registration form")
    public UserResponseDto register(@RequestBody @Valid UserRegistrationDto userRequestDto) {
        User user = authService.register(userRequestDto.getEmail(),
                userRequestDto.getPassword(),
                userRequestDto.getFirstName(),
                userRequestDto.getLastName());
        return userMapper.mapToDto(user);
    }

    @PostMapping("/login")
    @ApiOperation(value = "User login form")
    public ResponseEntity<Object> login(@RequestBody @Valid UserLoginDto userLoginDto)
            throws AuthenticationException {
        User user = authService.login(
                userLoginDto.getLogin(), userLoginDto.getPassword());
        String token = jwtTokenProvider.createToken(user.getEmail(), user.getRoles().stream()
                .map(r -> r.getRoleName().name())
                .collect(Collectors.toList()));
        return new ResponseEntity<>(Map.of("token", token), HttpStatus.OK);
    }

    @GetMapping("/verify")
    @ApiOperation(value = "Verifying user email endpoint")
    public ModelAndView verifyEmail(@RequestParam String token) {
        authService.verifyEmail(token);
        return new ModelAndView("redirect:https://www.google.com");
    }
}
