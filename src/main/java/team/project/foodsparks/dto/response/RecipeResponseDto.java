package team.project.foodsparks.dto.response;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeResponseDto {
    private Long id;
    private String dishName;
    private String cuisineRegion;
    private String dishType;
    private Map<String, Double> productList;
    private boolean spiced;
    private String instructions;
    private String cookingTime;
    private Integer portions;
    private String imageUrl;
}
