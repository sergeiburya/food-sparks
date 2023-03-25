package team.project.foodsparks.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String region;
    private String town;
    private String street;
    private String build;
    private int apartment;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Address address = (Address) obj;
        return getId() != null
                && Objects.equals(getId(), address.getId())
                && Objects.equals(getRegion(), address.getRegion())
                && Objects.equals(getTown(), address.getTown())
                && Objects.equals(getStreet(), address.getStreet())
                && Objects.equals(getBuild(), address.getBuild())
                && Objects.equals(getApartment(), address.getApartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, region, town, street, build, apartment);
    }
}
