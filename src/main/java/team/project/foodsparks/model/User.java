package team.project.foodsparks.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    private boolean emailConfirmed;
    private String password;
    private String phone;
    private LocalDate birthdate;
    @OneToOne
    private Gender gender;

    @ManyToMany
    private Set<Role> roles;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return getId() != null
                && Objects.equals(getId(), user.getId())
                && Objects.equals(getFirstName(), user.getFirstName())
                && Objects.equals(getLastName(), user.getLastName())
                && Objects.equals(getEmail(), user.getEmail())
                && Objects.equals(getPassword(), user.getPassword())
                && Objects.equals(getBirthdate(), user.getBirthdate())
                && Objects.equals(getPhone(), user.getPhone())
                && Objects.equals(getGender(), user.getGender())
                && Objects.equals(getRoles(), user.getRoles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName,email,
                password, phone,birthdate,gender, roles);
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", email='" + email + '\''
                + ", phone='" + phone + '\''
                + ", birthdate=" + birthdate
                + ", gender=" + gender
                + ", roles=" + roles + '}';
    }
}
