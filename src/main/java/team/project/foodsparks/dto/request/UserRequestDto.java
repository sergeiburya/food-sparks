package team.project.foodsparks.dto.request;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private String phone;
    private LocalDate birthdate;
    private Long genderId;
    private String firstName;
    private String lastName;
}
