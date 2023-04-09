package team.project.foodsparks.service.mapper;

import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.response.CuisineRegionResponseDto;
import team.project.foodsparks.model.CuisineRegion;

@Component
public class CuisineRegionMapper
        implements ResponseDtoMapper<CuisineRegionResponseDto, CuisineRegion> {
    @Override
    public CuisineRegionResponseDto mapToDto(CuisineRegion cuisineRegion) {
        CuisineRegionResponseDto dto = new CuisineRegionResponseDto();
        dto.setName(cuisineRegion.getCuisineRegionName().toString());
        dto.setId(cuisineRegion.getId());
        dto.setImageUrl(cuisineRegion.getImageUrl());
        return dto;
    }
}
