package team.project.foodsparks.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.project.foodsparks.dto.request.RecipeRequestDto;
import team.project.foodsparks.dto.response.RecipeResponseDto;
import team.project.foodsparks.model.CuisineRegion;
import team.project.foodsparks.model.Recipe;
import team.project.foodsparks.service.RecipeService;
import team.project.foodsparks.service.mapper.RequestDtoMapper;
import team.project.foodsparks.service.mapper.ResponseDtoMapper;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;
    private final RequestDtoMapper<RecipeRequestDto, Recipe> recipeRequestDtoMapper;
    private final ResponseDtoMapper<RecipeResponseDto, Recipe> recipeResponseDtoMapper;

    @Autowired
    public RecipeController(RecipeService recipeService,
                            RequestDtoMapper<RecipeRequestDto, Recipe> recipeRequestDtoMapper,
                            ResponseDtoMapper<RecipeResponseDto, Recipe> recipeResponseDtoMapper) {
        this.recipeService = recipeService;
        this.recipeRequestDtoMapper = recipeRequestDtoMapper;
        this.recipeResponseDtoMapper = recipeResponseDtoMapper;
    }

    @PostMapping
    public RecipeResponseDto save(@RequestBody RecipeRequestDto recipeRequestDto) {
        Recipe recipe = recipeRequestDtoMapper.mapToModel(recipeRequestDto);
        return recipeResponseDtoMapper.mapToDto(recipeService.save(recipe));
    }

    @GetMapping
    public List<RecipeResponseDto> getAll() {
        return recipeService.getAll()
                .stream()
                .map(recipeResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RecipeResponseDto getById(@PathVariable Long id) {
        Recipe recipe = recipeService.getById(id).orElseThrow(
                () -> new RuntimeException("Recipe by id: " + id + " doesn't exist.")
        );
        return recipeResponseDtoMapper.mapToDto(recipe);
    }

    @GetMapping("/regions")
    public List<RecipeResponseDto> getDishesByCuisineRegion(@RequestParam String cuisineRegion) {
        return recipeService.getRecipeByCuisineRegion(CuisineRegion
                .valueOf(cuisineRegion.toUpperCase()))
                .stream()
                .map(recipeResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
