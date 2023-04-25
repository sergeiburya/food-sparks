package team.project.foodsparks.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode
@Getter
@Setter
public class CuisineRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private CuisineRegionName cuisineRegionName;
    private String imageUrl;

    public enum CuisineRegionName {
        ODESKA("Одеська"),
        GALYCKA("Галицька"),
        KRYMSKA("Кримська"),
        VOLYNSKA("Волинська"),
        PODILSKA("Подільска"),
        ZAKARPATSKA("Закарпатська");

        private final String value;

        CuisineRegionName(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
