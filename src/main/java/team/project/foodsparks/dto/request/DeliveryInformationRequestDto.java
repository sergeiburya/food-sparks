package team.project.foodsparks.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryInformationRequestDto {
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
