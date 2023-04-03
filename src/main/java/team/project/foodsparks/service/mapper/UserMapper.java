package team.project.foodsparks.service.mapper;

import java.util.HashSet;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.UserRegistrationDto;
import team.project.foodsparks.dto.response.UserResponseDto;
import team.project.foodsparks.model.Role;
import team.project.foodsparks.model.User;

@Component
public class UserMapper implements
        ResponseDtoMapper<UserResponseDto, User>,
        RequestDtoMapper<UserRegistrationDto, User> {

    @Override
    public User mapToModel(UserRegistrationDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRoles(new HashSet<>());
        return user;
    }

    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setEmailConfirmed(user.isEmailConfirmed());
        userResponseDto.setRoleId(user.getRoles()
                .stream()
                .map(Role::getId)
                .collect(Collectors.toList()));
        return userResponseDto;
    }
}
