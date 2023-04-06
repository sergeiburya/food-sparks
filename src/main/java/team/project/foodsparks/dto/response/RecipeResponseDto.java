package team.project.foodsparks.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import team.project.foodsparks.dto.serializer.RecipeProductListSerializer;
import team.project.foodsparks.model.Product;

@Getter
@Setter
public class RecipeResponseDto {
    private Long id;
    private String dishName;
    private String cuisineRegion;
    private String dishType;
    @JsonSerialize(using = RecipeProductListSerializer.class)
    private Map<Product,Double> productsList;
    private boolean spiced;
    private String instructions;
    private String cookingTime;
    private Integer portions;
    private String imageUrl;
}
