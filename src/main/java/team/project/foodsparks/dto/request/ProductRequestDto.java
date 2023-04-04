package team.project.foodsparks.dto.request;

import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
    private String name;
    private String manufacturer;
    private BigDecimal price;
    private Integer amountInPackage;
    private List<Long> ingredientList;
}
