package team.project.foodsparks.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryInformationResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String town;
    private String street;
    private String build;
    private int apartment;
    private String comment;
    private String dayOfDelivery;
    private String timeOfDelivery;
}
