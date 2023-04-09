package team.project.foodsparks.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.project.foodsparks.dto.request.RecipeRequestDto;
import team.project.foodsparks.dto.response.RecipeResponseDto;
import team.project.foodsparks.dto.response.RecipeSmallCartResponseDto;
import team.project.foodsparks.model.Recipe;
import team.project.foodsparks.service.RecipeService;
import team.project.foodsparks.service.mapper.RequestDtoMapper;
import team.project.foodsparks.service.mapper.ResponseDtoMapper;

@RestController
@RequestMapping("/recipes")
@CrossOrigin(origins = "*")
public class RecipeController {
    private final RecipeService recipeService;
    private final RequestDtoMapper<RecipeRequestDto, Recipe> recipeRequestMapper;
    private final ResponseDtoMapper<RecipeResponseDto, Recipe> recipeResponseMapper;
    private final ResponseDtoMapper<RecipeSmallCartResponseDto, Recipe> recipeSmallResponseMapper;

    @Autowired
    public RecipeController(RecipeService recipeService,
                            RequestDtoMapper<RecipeRequestDto, Recipe> recipeRequestMapper,
                            ResponseDtoMapper<RecipeResponseDto, Recipe> recipeResponseMapper,
                            ResponseDtoMapper<RecipeSmallCartResponseDto,
                                    Recipe> recipeSmallResponseMapper) {
        this.recipeService = recipeService;
        this.recipeRequestMapper = recipeRequestMapper;
        this.recipeResponseMapper = recipeResponseMapper;
        this.recipeSmallResponseMapper = recipeSmallResponseMapper;
    }

    @PostMapping
    @ApiOperation(value = "Add new recipe")
    public RecipeResponseDto save(@RequestBody RecipeRequestDto recipeRequestDto) {
        Recipe recipe = recipeRequestMapper.mapToModel(recipeRequestDto);
        return recipeResponseMapper.mapToDto(recipeService.save(recipe));
    }

    @GetMapping
    @ApiOperation(value = "Get all recipes")
    public List<RecipeSmallCartResponseDto> getAll(@RequestParam(defaultValue = "9999999")
                                                   Integer count,
                                                   @RequestParam(defaultValue = "0")
                                                   Integer page,
                                                   @RequestParam Map<String, String> params) {
        PageRequest pageRequest = PageRequest.of(page, count);
        params.remove("count");
        params.remove("page");
        return recipeService.findAll(params, pageRequest)
                .stream()
                .map(recipeSmallResponseMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/quantity/{count}")
    @ApiOperation(value = "This endpoint for test purpose. "
            + "Get quantity of recipes that specified in param {count}")
    public List<RecipeSmallCartResponseDto> getSpecifiedQuantityOfRecipes(
            @PathVariable Long count) {
        return recipeService.getByIdLessThan(count)
                .stream()
                .map(recipeSmallResponseMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get recipe by ID")
    public RecipeResponseDto getById(@PathVariable Long id) {
        Recipe recipe = recipeService.getById(id).orElseThrow(
                () -> new RuntimeException("Recipe by id: " + id + " doesn't exist.")
        );
        return recipeResponseMapper.mapToDto(recipe);
    }

    @GetMapping("/byRegions")
    @ApiOperation(value = "Get recipes by cuisine region ID")
    public List<RecipeSmallCartResponseDto> getDishesByCuisineRegion(@RequestParam Long id) {
        return recipeService.findRecipeByCuisineRegionId(id)
                .stream()
                .map(recipeSmallResponseMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/byDishType")
    @ApiOperation(value = "Get recipes by dish type ID.")
    public List<RecipeSmallCartResponseDto> getDishesByDishTypeId(@RequestParam Long id) {
        return recipeService.findRecipeByDishTypeId(id)
                .stream()
                .map(recipeSmallResponseMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
