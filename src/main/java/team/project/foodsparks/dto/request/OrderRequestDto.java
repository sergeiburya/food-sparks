package team.project.foodsparks.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {
    private String comment;
    private String dayOfDelivery;
    private String timeOfDelivery;
}
