package team.project.foodsparks.service.mapper;

import java.util.HashSet;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.UserRegistrationRequestDto;
import team.project.foodsparks.dto.request.UserRegistrationResponseDto;
import team.project.foodsparks.dto.response.UserResponseDto;
import team.project.foodsparks.model.Role;
import team.project.foodsparks.model.User;

@Component
public class UserMapper implements
        ResponseDtoMapper<UserResponseDto, User>,
        RequestDtoMapper<UserRegistrationRequestDto, User> {

    @Override
    public User mapToModel(UserRegistrationRequestDto dto) {
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
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setEmailConfirmed(user.isEmailConfirmed());
        userResponseDto.setPhone(user.getPhone());
        userResponseDto.setBirthdate(user.getBirthdate());
        userResponseDto.setGenderId(user.getGender() != null ? user.getGender().getId() : null);
        userResponseDto.setRoleId(user.getRoles()
                .stream()
                .map(Role::getId)
                .collect(Collectors.toList()));
        return userResponseDto;
    }

    public UserRegistrationResponseDto mapToResponseDto(User user) {
        UserRegistrationResponseDto registrationResponseDto = new UserRegistrationResponseDto();
        registrationResponseDto.setId(user.getId());
        registrationResponseDto.setEmail(user.getEmail());
        registrationResponseDto.setFirstName(user.getFirstName());
        registrationResponseDto.setLastName(user.getLastName());
        return registrationResponseDto;
    }
}
