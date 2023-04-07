package team.project.foodsparks.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.project.foodsparks.dto.response.CuisineRegionResponseDto;
import team.project.foodsparks.model.CuisineRegion;
import team.project.foodsparks.service.CuisineRegionService;
import team.project.foodsparks.service.mapper.ResponseDtoMapper;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cuisine-regions")
public class CuisineRegionController {
    private final CuisineRegionService cuisineRegionService;
    private final ResponseDtoMapper<CuisineRegionResponseDto, CuisineRegion> responseMapper;

    public CuisineRegionController(CuisineRegionService cuisineRegionService,
                                   ResponseDtoMapper<CuisineRegionResponseDto,
                                           CuisineRegion> responseMapper) {
        this.cuisineRegionService = cuisineRegionService;
        this.responseMapper = responseMapper;
    }

    @GetMapping
    @ApiOperation(value = "Get all Cuisine Regions")
    public List<CuisineRegionResponseDto> getAll() {
        return cuisineRegionService.getAll()
                .stream()
                .map(responseMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
