package team.project.foodsparks.dto.request;

import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import team.project.foodsparks.model.CuisineRegion;

@Getter
@Setter
public class RecipeRequestDto {
    private String dishName;
    private CuisineRegion cuisineRegion;
    private Map<Long, Double> productList;
    private boolean spiced;
    private List<String> instructions;
    private Integer cookingTime;
    private Integer portions;
    private String imageUrl;
}
