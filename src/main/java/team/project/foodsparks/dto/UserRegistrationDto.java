package team.project.foodsparks.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto {
    private String email;
    @NotEmpty(message = "The password couldn't be empty")
    @Size(min = 8, max = 72,message = "Password must be at least 8 symbols long")
    private String password;
    private String repeatPassword;
    private String firstName;
    private String lastName;
}
