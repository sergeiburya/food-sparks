package team.project.foodsparks.dto.request;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.project.foodsparks.lib.FieldsValueMatch;
import team.project.foodsparks.lib.ValidEmail;

@FieldsValueMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "Passwords do not match!")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    @ValidEmail
    private String email;
    @Size(min = 8, max = 72)
    private String password;
    private String repeatPassword;
    private String firstName;
    private String lastName;
    private boolean emailConfirmed;
    private String phone;
    private LocalDate birthdate;
    private Long addressId;
    private Long genderId;
    private List<Long> roleId;
}
