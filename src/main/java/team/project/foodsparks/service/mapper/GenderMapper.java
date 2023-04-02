package team.project.foodsparks.service.mapper;

import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.response.GenderResponseDto;
import team.project.foodsparks.model.Gender;

@Component
public class GenderMapper implements
        ResponseDtoMapper<GenderResponseDto, Gender> {
    @Override
    public GenderResponseDto mapToDto(Gender gender) {
        GenderResponseDto genderResponseDto = new GenderResponseDto();
        genderResponseDto.setId(gender.getId());
        genderResponseDto.setGender(gender.getGenderName().name());
        return genderResponseDto;
    }
}
