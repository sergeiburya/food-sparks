package team.project.foodsparks.dto.request;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import team.project.foodsparks.model.CuisineRegion;

@Getter
@Setter
public class RecipeRequestDto {
    private String dishName;
    private CuisineRegion cuisineRegion;
    private Map<Long, Double> ingredientList;
    private boolean spiced;
    private String instructions;
    private String imageUrl;
}
