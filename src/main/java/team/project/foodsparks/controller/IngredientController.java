package team.project.foodsparks.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.project.foodsparks.dto.request.IngredientRequestDto;
import team.project.foodsparks.dto.response.IngredientResponseDto;
import team.project.foodsparks.model.Ingredient;
import team.project.foodsparks.service.IngredientService;
import team.project.foodsparks.service.mapper.RequestDtoMapper;
import team.project.foodsparks.service.mapper.ResponseDtoMapper;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;
    private final RequestDtoMapper<IngredientRequestDto, Ingredient> ingredientRequestDtoMapper;
    private final ResponseDtoMapper<IngredientResponseDto, Ingredient> ingredientResponseDtoMapper;

    @Autowired
    public IngredientController(IngredientService ingredientService,
                                RequestDtoMapper<IngredientRequestDto,
                                        Ingredient> ingredientRequestDtoMapper,
                                ResponseDtoMapper<IngredientResponseDto,
                                        Ingredient> ingredientResponseDtoMapper) {
        this.ingredientService = ingredientService;
        this.ingredientRequestDtoMapper = ingredientRequestDtoMapper;
        this.ingredientResponseDtoMapper = ingredientResponseDtoMapper;
    }

    @PostMapping
    public IngredientResponseDto save(@RequestBody IngredientRequestDto ingredientRequestDto) {
        Ingredient ingredient = ingredientService.save(ingredientRequestDtoMapper
                .mapToModel(ingredientRequestDto));
        return ingredientResponseDtoMapper.mapToDto(ingredient);
    }

    @GetMapping("/{id}")
    public IngredientResponseDto getById(@PathVariable Long id) {
        Ingredient ingredient = ingredientService.getById(id).orElseThrow(
                () -> new RuntimeException("Ingredient with id: " + id + " not found.")
        );
        return ingredientResponseDtoMapper.mapToDto(ingredient);
    }

    @GetMapping()
    public List<IngredientResponseDto> getAll() {
        return ingredientService.getAll().stream()
                .map(ingredientResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}