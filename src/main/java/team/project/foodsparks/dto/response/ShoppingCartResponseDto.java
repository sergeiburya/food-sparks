package team.project.foodsparks.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.math.BigDecimal;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.project.foodsparks.dto.serializer.ShoppingCartProductMapSerializer;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartResponseDto {
    @JsonSerialize(using = ShoppingCartProductMapSerializer.class)
    private Map<ProductResponseDto, Integer> productAmount;
    private Long userId;
    private BigDecimal sum;
}
