package team.project.foodsparks.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.project.foodsparks.dto.response.ComplexityResponseDto;
import team.project.foodsparks.service.ComplexityService;
import team.project.foodsparks.service.mapper.ComplexityMapper;

@RestController
@RequestMapping("/complexities")
public class ComplexityController {
    private final ComplexityService complexityService;
    private final ComplexityMapper complexityMapper;

    @Autowired
    public ComplexityController(ComplexityService complexityService,
                                ComplexityMapper complexityMapper) {
        this.complexityService = complexityService;
        this.complexityMapper = complexityMapper;
    }

    @GetMapping
    @ApiOperation(value = "Get all complexities")
    public List<ComplexityResponseDto> getAll() {
        return complexityService.getAll()
                .stream()
                .map(complexityMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
