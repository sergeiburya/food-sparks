package team.project.foodsparks.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.project.foodsparks.dto.request.UserRequestDto;
import team.project.foodsparks.dto.response.UserResponseDto;
import team.project.foodsparks.model.User;
import team.project.foodsparks.service.UserService;
import team.project.foodsparks.service.mapper.ResponseDtoMapper;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final ResponseDtoMapper<UserResponseDto, User> userResponseDtoMapper;

    @Autowired
    public UserController(UserService userService,
                          ResponseDtoMapper<UserResponseDto, User> userResponseDtoMapper) {
        this.userService = userService;
        this.userResponseDtoMapper = userResponseDtoMapper;
    }

    @GetMapping("/all_users")
    @ApiOperation(value = "Get all users")
    public List<UserResponseDto> getAllUsers() {
        return userService.findAll().stream()
                .map(userResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/by-email")
    @ApiOperation(value = "Get user by email")
    public UserResponseDto findByEmail(@RequestParam String email) {
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        return userResponseDtoMapper.mapToDto(user);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update user data")
    public UserResponseDto updateUserData(@RequestParam String email,
                                          @RequestBody UserRequestDto userRequestDto) {
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        user.setPhone(userRequestDto.getPhone());
        user.setBirthdate(userRequestDto.getBirthdate());
        userService.add(user);
        return userResponseDtoMapper.mapToDto(user);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "Delete User By Id")
    void delete(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
