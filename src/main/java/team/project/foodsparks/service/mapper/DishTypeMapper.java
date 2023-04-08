package team.project.foodsparks.service.mapper;

import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.response.DishTypeResponseDto;
import team.project.foodsparks.model.DishType;

@Component
public class DishTypeMapper implements ResponseDtoMapper<DishTypeResponseDto, DishType> {
    @Override
    public DishTypeResponseDto mapToDto(DishType dishType) {
        DishTypeResponseDto dto = new DishTypeResponseDto();
        dto.setDishTypeName(dishType.getDishTypeName().toString());
        dto.setId(dishType.getId());
        return dto;
    }
}
