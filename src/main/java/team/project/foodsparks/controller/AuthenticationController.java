package team.project.foodsparks.controller;

import io.swagger.annotations.ApiOperation;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import team.project.foodsparks.dto.UserLoginRequestDto;
import team.project.foodsparks.dto.UserRegistrationRequestDto;
import team.project.foodsparks.exception.AuthenticationException;
import team.project.foodsparks.model.User;
import team.project.foodsparks.security.JwtTokenProvider;
import team.project.foodsparks.service.AuthenticationService;

@RestController
@CrossOrigin(origins = "*")
public class AuthenticationController {
    private final AuthenticationService authService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthenticationController(AuthenticationService authService,
                                    JwtTokenProvider jwtTokenProvider) {
        this.authService = authService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    @ApiOperation(value = "User registration form")
    public String register(
            @RequestBody UserRegistrationRequestDto userRequestDto)
            throws AuthenticationException {
        authService.register(userRequestDto.getEmail(),
                userRequestDto.getPassword(),
                userRequestDto.getFirstName(),
                userRequestDto.getLastName());
        return "Ви успішно зареестровані";
    }

    @PostMapping("/login")
    @ApiOperation(value = "User login form")
    public ResponseEntity<Object> login(@RequestBody @Valid UserLoginRequestDto userLoginDto)
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
