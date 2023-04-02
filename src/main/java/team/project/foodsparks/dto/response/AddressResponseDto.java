package team.project.foodsparks.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponseDto {
    private Long id;
    private String region;
    private String town;
    private String street;
    private String build;
    private int apartment;
}
