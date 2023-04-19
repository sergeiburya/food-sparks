package team.project.foodsparks.dto.request;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
    private String name;
    private BigDecimal price;
    private Integer amountInPackage;
    private String imageUrl;
}
