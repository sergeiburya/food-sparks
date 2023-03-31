package team.project.foodsparks.dto.response;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import team.project.foodsparks.model.CuisineRegion;

@Getter
@Setter
public class RecipeResponseDto {
    private Long id;
    private String dishName;
    private CuisineRegion cuisineRegion;
    private Map<String, Double> ingredientList;
    private boolean spiced;
    private String instructions;
    private String imageUrl;
}
