package team.project.foodsparks.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeSmallCartResponseDto {
    private Long id;
    private String dishName;
    private String imageUrl;
    private String cookingTime;
    private Integer portions;
    private String dishType;
}
