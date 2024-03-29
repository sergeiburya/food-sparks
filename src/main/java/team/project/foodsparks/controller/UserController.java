package team.project.foodsparks.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.project.foodsparks.dto.request.UserRequestDto;
import team.project.foodsparks.dto.response.UserResponseDto;
import team.project.foodsparks.exception.DataProcessingException;
import team.project.foodsparks.model.User;
import team.project.foodsparks.service.GenderService;
import team.project.foodsparks.service.UserService;
import team.project.foodsparks.service.mapper.ResponseDtoMapper;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;
    private final ResponseDtoMapper<UserResponseDto, User> userResponseDtoMapper;
    private final GenderService genderService;

    @Autowired
    public UserController(UserService userService,
                          ResponseDtoMapper<UserResponseDto, User> userResponseDtoMapper,
                          GenderService genderService) {
        this.userService = userService;
        this.userResponseDtoMapper = userResponseDtoMapper;
        this.genderService = genderService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all users")
    public List<UserResponseDto> getAllUsers() {
        return userService.findAll().stream()
                .map(userResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping()
    @ApiOperation(value = "Get user by email")
    public UserResponseDto findByEmail(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new DataProcessingException("Користувача з імейлом: "
                        + email + " не існує."));
        return userResponseDtoMapper.mapToDto(user);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update user data")
    public UserResponseDto updateUserData(Authentication auth,
                                          @RequestBody UserRequestDto userRequestDto) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new DataProcessingException("Користувача з імейлом: "
                        + email + " не існує."));
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setPhone(userRequestDto.getPhone());
        user.setBirthdate(userRequestDto.getBirthdate());
        user.setGender(genderService.getById(userRequestDto.getGenderId()).get());
        userService.add(user);
        return userResponseDtoMapper.mapToDto(user);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete User By Id for Admin Role")
    @Transactional
    public void deleteById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "Delete User by email for User Role")
    @Transactional
    public void deleteByEmail(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        userService.deleteByEmail(email);
    }
}
