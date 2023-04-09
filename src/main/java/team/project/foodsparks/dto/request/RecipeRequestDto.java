package team.project.foodsparks.dto.request;

import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeRequestDto {
    private String title;
    private String subtitle;
    private Long cuisineRegionId;
    private Long dishTypeId;
    private Map<Long, Double> productList;
    private boolean spiced;
    private List<String> instructions;
    private Integer cookingTime;
    private Integer portions;
    private String imageUrl;
}
