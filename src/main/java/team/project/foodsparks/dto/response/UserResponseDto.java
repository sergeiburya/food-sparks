package team.project.foodsparks.dto.response;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private boolean emailConfirmed;
    private String phone;
    private LocalDate birthdate;
    private Long genderId;
    private List<Long> roleId;
}
