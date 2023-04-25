package team.project.foodsparks.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.project.foodsparks.dto.serializer.ShoppingCartProductMapSerializer;
import team.project.foodsparks.model.CartItem;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartResponseDto {
    @JsonSerialize(using = ShoppingCartProductMapSerializer.class)
    private List<CartItem> productAmount;
    private Long userId;
    private BigDecimal sum;
}
