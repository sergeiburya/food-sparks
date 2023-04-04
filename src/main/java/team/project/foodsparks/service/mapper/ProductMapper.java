package team.project.foodsparks.service.mapper;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.request.ProductRequestDto;
import team.project.foodsparks.dto.response.ProductResponseDto;
import team.project.foodsparks.model.Product;
import team.project.foodsparks.service.IngredientService;

@Component
public class ProductMapper implements RequestDtoMapper<ProductRequestDto, Product>,
        ResponseDtoMapper<ProductResponseDto, Product> {
    private final IngredientService ingredientService;

    public ProductMapper(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Override
    public Product mapToModel(ProductRequestDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setAmountInPackage(dto.getAmountInPackage());
        product.setIngredientTag(dto.getIngredientList().stream()
                .map(i -> ingredientService.getById(i).get())
                .collect(Collectors.toList()));
        product.setManufacturer(dto.getManufacturer());
        return product;
    }

    @Override
    public ProductResponseDto mapToDto(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setManufacturer(product.getManufacturer());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setAmountInPackage(product.getAmountInPackage());
        return dto;
    }
}
