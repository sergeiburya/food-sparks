package team.project.foodsparks.dto.response;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer amountInPackage;
    private String imageUrl;
}
