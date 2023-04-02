package team.project.foodsparks.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequestDto {
    private String region;
    private String town;
    private String street;
    private String build;
    private int apartment;
}
