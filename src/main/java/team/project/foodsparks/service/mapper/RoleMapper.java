package team.project.foodsparks.service.mapper;

import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.response.RoleResponseDto;
import team.project.foodsparks.model.Role;

@Component
public class RoleMapper implements ResponseDtoMapper<RoleResponseDto,Role> {

    @Override
    public RoleResponseDto mapToDto(Role role) {
        RoleResponseDto roleResponseDto = new RoleResponseDto();
        roleResponseDto.setId(role.getId());
        roleResponseDto.setRole(role.getRoleName().name());
        return roleResponseDto;
    }
}
