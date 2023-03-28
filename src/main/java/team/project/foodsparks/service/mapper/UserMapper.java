package team.project.foodsparks.service.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.UserRegistrationDto;
import team.project.foodsparks.dto.response.RoleResponseDto;
import team.project.foodsparks.dto.response.UserResponseDto;
import team.project.foodsparks.model.Role;
import team.project.foodsparks.model.User;

@Component
public class UserMapper implements
        ResponseDtoMapper<UserResponseDto, User>,
        RequestDtoMapper<UserRegistrationDto, User> {
    private final RoleMapper roleMapper;

    @Autowired
    public UserMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

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
        userResponseDto.setEmail(user.getEmail());
        List<Long> list = new ArrayList<>();
        for (Role role : user.getRoles()) {
            RoleResponseDto roleResponseDto = roleMapper.mapToDto(role);
            list.add(roleResponseDto.getId());
        }
        userResponseDto.setRoleId(list);
        return userResponseDto;
    }
}
