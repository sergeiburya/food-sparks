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

    public enum CuisineRegionName {
        GALYCKA("Галицька"),
        ZAKARPATSKA("Закарпатська"),
        ODESKA("Одеська"),
        VOLYNSKA("Волинська"),
        POLISKA("Поліська"),
        BYKOVINSKA("Буковинська"),
        KRYMSKA("Кримська"),
        SLOBOZHANSKA("Слобожанська"),
        PODILSKA("Подільска"),
        NADDNIPRIANSKA("Наддніпрянська"),
        ZAPORIZKA("Запорізька");

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
