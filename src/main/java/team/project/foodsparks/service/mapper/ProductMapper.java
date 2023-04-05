package team.project.foodsparks.service.mapper;

import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.request.ProductRequestDto;
import team.project.foodsparks.dto.response.ProductResponseDto;
import team.project.foodsparks.model.Product;
import team.project.foodsparks.service.ProductService;

@Component
public class ProductMapper implements RequestDtoMapper<ProductRequestDto, Product>,
        ResponseDtoMapper<ProductResponseDto, Product> {

    @Override
    public Product mapToModel(ProductRequestDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setAmountInPackage(dto.getAmountInPackage());
        return product;
    }

    @Override
    public ProductResponseDto mapToDto(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setAmountInPackage(product.getAmountInPackage());
        return dto;
    }
}
