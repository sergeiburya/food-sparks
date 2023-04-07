package team.project.foodsparks.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.project.foodsparks.dto.response.DishTypeResponseDto;
import team.project.foodsparks.service.DishTypeService;
import team.project.foodsparks.service.mapper.DishTypeMapper;

@RestController
@RequestMapping("/dish-types")
@CrossOrigin(origins = "*")
public class DishTypeController {
    private final DishTypeService dishTypeService;
    private final DishTypeMapper dishTypeMapper;

    @Autowired
    public DishTypeController(DishTypeService dishTypeService,
                              DishTypeMapper dishTypeMapper) {
        this.dishTypeService = dishTypeService;
        this.dishTypeMapper = dishTypeMapper;
    }

    @GetMapping
    @ApiOperation(value = "Get all Dish Types")
    public List<DishTypeResponseDto> getAll() {
        return dishTypeService.getAll()
                .stream()
                .map(dishTypeMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
