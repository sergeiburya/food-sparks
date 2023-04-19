package team.project.foodsparks.service.mapper;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.response.ProductResponseDto;
import team.project.foodsparks.dto.response.ShoppingCartResponseDto;
import team.project.foodsparks.model.Product;
import team.project.foodsparks.model.ShoppingCart;

@Component
public class ShoppingCartMapper implements
        ResponseDtoMapper<ShoppingCartResponseDto, ShoppingCart> {
    private final ResponseDtoMapper<ProductResponseDto, Product> productMapper;

    public ShoppingCartMapper(ResponseDtoMapper<ProductResponseDto, Product> productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public ShoppingCartResponseDto mapToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setUserId(shoppingCart.getUser().getId());
        responseDto.setProductAmount(shoppingCart.getProductAmount()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(m
                        -> productMapper.mapToDto(m.getKey()), Map.Entry::getValue)));
        responseDto.setSum(shoppingCart.getProductAmount()
                .entrySet()
                .stream()
                .map(e -> e.getKey().getPrice().multiply(BigDecimal.valueOf(e.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .divide(BigDecimal.valueOf(100))
                .multiply(BigDecimal.valueOf(shoppingCart.getCoupon() != null
                        ? 100 - shoppingCart.getCoupon().getDiscountSize() : 100)));
        return responseDto;
    }
}
