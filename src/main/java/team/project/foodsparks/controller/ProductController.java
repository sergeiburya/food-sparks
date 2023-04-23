package team.project.foodsparks.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.project.foodsparks.dto.request.ProductRequestDto;
import team.project.foodsparks.dto.response.ProductResponseDto;
import team.project.foodsparks.exception.DataProcessingException;
import team.project.foodsparks.model.Product;
import team.project.foodsparks.service.ProductService;
import team.project.foodsparks.service.mapper.RequestDtoMapper;
import team.project.foodsparks.service.mapper.ResponseDtoMapper;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {
    private final RequestDtoMapper<ProductRequestDto, Product> requestDtoMapper;
    private final ResponseDtoMapper<ProductResponseDto, Product> responseDtoMapper;
    private final ProductService productService;

    public ProductController(RequestDtoMapper<ProductRequestDto, Product> requestDtoMapper,
                             ResponseDtoMapper<ProductResponseDto, Product> responseDtoMapper,
                             ProductService productService) {
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
        this.productService = productService;
    }

    @PostMapping
    @ApiOperation(value = "Create a new product")
    public ProductResponseDto save(@RequestBody ProductRequestDto productRequestDto) {
        Product product = requestDtoMapper.mapToModel(productRequestDto);
        System.out.println(product.toString());
        return responseDtoMapper.mapToDto(productService.add(product));
    }

    @GetMapping
    @ApiOperation(value = "Get all existing products")
    public List<ProductResponseDto> getAll() {
        return productService.getAll()
                .stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get product by id")
    public ProductResponseDto getById(@PathVariable Long id) {
        Product product = productService.getById(id).orElseThrow(
                () -> new DataProcessingException("Продукт з id: " + id + " не знайдено."));
        return responseDtoMapper.mapToDto(product);
    }
}
