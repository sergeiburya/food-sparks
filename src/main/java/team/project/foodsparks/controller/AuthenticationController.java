package team.project.foodsparks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.project.foodsparks.dto.request.UserRequestDto;
import team.project.foodsparks.dto.response.UserResponseDto;
import team.project.foodsparks.model.User;
import team.project.foodsparks.service.AuthenticationService;
import team.project.foodsparks.service.mapper.ResponseDtoMapper;
import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class AuthenticationController {
    private final AuthenticationService authService;
    private final ResponseDtoMapper<UserResponseDto, User> userDtoResponseMapper;

    @Autowired
    public AuthenticationController(AuthenticationService authService,
            ResponseDtoMapper<UserResponseDto, User> userDtoResponseMapper) {
        this.authService = authService;
        this.userDtoResponseMapper = userDtoResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto requestDto) {
        User user = authService.register(requestDto.getEmail(), requestDto.getPassword());
        return userDtoResponseMapper.mapToDto(user);
    }
}
