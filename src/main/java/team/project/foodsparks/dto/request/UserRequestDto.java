package team.project.foodsparks.dto.request;

import lombok.Getter;
import lombok.Setter;
import team.project.foodsparks.lib.FieldsValueMatch;
import team.project.foodsparks.lib.ValidEmail;
import javax.validation.constraints.Size;
import java.util.List;

@FieldsValueMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "Passwords do not match!")
@Getter
@Setter
public class UserRequestDto {
    @ValidEmail
    private String email;
    @Size(min = 8, max = 72)
    private String password;
    private String repeatPassword;
    private List<Long> roleId;
}
