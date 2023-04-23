package team.project.foodsparks.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
import team.project.foodsparks.exception.DataProcessingException;
import team.project.foodsparks.model.Recipe;
import team.project.foodsparks.service.RecipeService;
import team.project.foodsparks.service.mapper.RequestDtoMapper;
import team.project.foodsparks.service.mapper.ResponseDtoMapper;
import team.project.foodsparks.util.SortOrderParser;

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
    @ApiOperation(value = "Get all recipes with possibilities to filter, sort and pagination")
    public Page<RecipeSmallCartResponseDto> getAll(@ApiParam(value = "If this parameter is defined"
            + " in request, then count of recipes in response will be equals to value. As default"
            + " value is 9999999 that's why if parameter isn't defined in response there will be"
            + " all recipes in single page")
                                                   @RequestParam(defaultValue = "9999999")
                                                   Integer count,
                                                   @ApiParam(value = "This parameter point on to"
            + " the specific page in response ( for example if we have at all 100 recipes and"
            + " specify the count param as 10, then in every page we will be getting part of "
            + "10 recipes.)")
                                                   @RequestParam(defaultValue = "0") Integer page,
                                                   @ApiParam(value = "If this parameter isn't"
            + " defined in request, then all recipes in response will be sorted by id on ascending"
            + " order as default. You may specify by which field you want to sort and in which"
            + " order (ASC for ascending and DESC for descending) you want to get the response"
            + " (for example : /recipes?sortBy=title:DESC or /recipes?sortBy=title:ASC and also"
            + " you may specify the multiple sorting parameters like a"
            + " /recipes?sortBy=title:ASC;cookingTime:DESC)")
                                                   @RequestParam(defaultValue = "id") String sortBy,
                                                   @ApiParam(value = "If this parameter is"
            + " defined in request, then all recipes in response will be filtered by specified"
            + " filters. At this time there are 5 filters ( \n 1. recipes?complexityIn="
            + "{id (or id's separated by commas) of complexity}, \n 2. recipes?cuisineRegionIn="
            + "{id (or id's separated by commas) of cuisine region}, \n 3. recipes?dishTypeIn="
            + "{id (or id's separated by commas) of dish type}, \n 4. recipes?productListIn="
            + "{id (or id's separated by commas) of products}, \n 5. recipes?spicedIn="
            + "{true or false}. \n - For example your request may contain filtering, sorting, "
            + "ordering, pagination and counting together, and looks like: \n  \n"
            + "- - recipes?cuisineRegionIn=1,2&complexityIn=1&sortBy=title:DESC&count=2&page=0")
                                                   @RequestParam Map<String, String> params) {
        params.remove("count");
        params.remove("page");
        params.remove("sortBy");
        List<Sort.Order> orders = SortOrderParser.getOrders(sortBy);
        Sort sort = Sort.by(orders);
        PageRequest pageRequest = PageRequest.of(page, count, sort);
        Page<Recipe> recipePages = recipeService.findAll(params, pageRequest);
        return recipePages.map(recipeSmallResponseMapper::mapToDto);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get recipe by ID")
    public RecipeResponseDto getById(@PathVariable Long id) {
        Recipe recipe = recipeService.getById(id).orElseThrow(
                () -> new DataProcessingException("Рецепт під id: " + id + " не знайдено.")
        );
        return recipeResponseMapper.mapToDto(recipe);
    }

    @GetMapping("/search")
    @ApiOperation(value = "Find recipes by letters contains in title")
    public List<RecipeSmallCartResponseDto> getByNameContains(@RequestParam String letters) {
        return recipeService.findByNameContains(letters)
                .stream()
                .map(recipeSmallResponseMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
