package team.project.foodsparks.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "genders")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private GenderName genderName;

    public enum GenderName {
        MALE, FEMALE, OTHER
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Gender gender = (Gender) obj;
        return getId() != null
                && Objects.equals(getId(), gender.getId())
                && Objects.equals(getGenderName(), gender.getGenderName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genderName);
    }

    @Override
    public String toString() {
        return "Gender{"
                + "id=" + id
                + ", genderName=" + genderName + '}';
    }
}
