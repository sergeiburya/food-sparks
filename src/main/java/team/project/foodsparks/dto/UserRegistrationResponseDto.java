package team.project.foodsparks.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationResponseDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
}
