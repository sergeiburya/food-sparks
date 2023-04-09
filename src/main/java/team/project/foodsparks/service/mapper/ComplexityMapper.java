package team.project.foodsparks.service.mapper;

import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.response.ComplexityResponseDto;
import team.project.foodsparks.model.Complexity;

@Component
public class ComplexityMapper
        implements ResponseDtoMapper<ComplexityResponseDto, Complexity> {
    @Override
    public ComplexityResponseDto mapToDto(Complexity complexity) {
        ComplexityResponseDto dto = new ComplexityResponseDto();
        dto.setId(complexity.getId());
        dto.setComplexityName(complexity.getComplexityName().toString());
        return dto;
    }
}
