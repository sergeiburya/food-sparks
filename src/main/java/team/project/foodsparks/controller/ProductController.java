package team.project.foodsparks.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.project.foodsparks.dto.request.ProductRequestDto;
import team.project.foodsparks.dto.response.ProductResponseDto;
import team.project.foodsparks.model.Ingredient;
import team.project.foodsparks.model.Product;
import team.project.foodsparks.service.IngredientService;
import team.project.foodsparks.service.ProductService;
import team.project.foodsparks.service.mapper.RequestDtoMapper;
import team.project.foodsparks.service.mapper.ResponseDtoMapper;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final RequestDtoMapper<ProductRequestDto, Product> requestDtoMapper;
    private final ResponseDtoMapper<ProductResponseDto, Product> responseDtoMapper;
    private final ProductService productService;
    private final IngredientService ingredientService;

    public ProductController(RequestDtoMapper<ProductRequestDto, Product> requestDtoMapper,
                             ResponseDtoMapper<ProductResponseDto, Product> responseDtoMapper,
                             ProductService productService, IngredientService ingredientService) {
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
        this.productService = productService;
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public ProductResponseDto save(ProductRequestDto productRequestDto) {
        Product product = requestDtoMapper.mapToModel(productRequestDto);
        return responseDtoMapper.mapToDto(productService.add(product));
    }

    @GetMapping
    public List<ProductResponseDto> getAll() {
        return productService.getAll()
                .stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductResponseDto getById(@PathVariable Long id) {
        Product product = productService.getById(id).orElseThrow(
                () -> new RuntimeException("Product with id: " + id + " not found."));
        return responseDtoMapper.mapToDto(product);
    }

    @GetMapping("/ingredient")
    List<ProductResponseDto> getByIngredientTagName(@RequestParam String name) {
        Ingredient ingredient = ingredientService.getByName(name)
                .orElseThrow(
                        () -> new RuntimeException("Product with name: " + name + " not found.")
                );
        return productService.getByIngredientTag(ingredient)
                .stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
