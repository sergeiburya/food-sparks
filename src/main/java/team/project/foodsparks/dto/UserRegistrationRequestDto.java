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
public class UserRegistrationRequestDto {
    @NotEmpty(message = "The email couldn't be empty")
    @Size(min = 5, max = 72,message = "Email must be at least 5 symbols long")
    private String email;
    @NotEmpty(message = "The password couldn't be empty")
    @Size(min = 8, max = 30, message = "Password must be at least 8 symbols long")
    private String password;
    @NotEmpty(message = "The First Name couldn't be empty.")
    @Size(min = 2, max = 40, message = "The length of the first name "
            + "must be between 2 and 40 characters")
    private String firstName;
    @NotEmpty(message = "The Last Name couldn't be empty.")
    @Size(min = 2, max = 40, message = "The length of the last name "
            + "must be between 2 and 40 characters")
    private String lastName;
}
