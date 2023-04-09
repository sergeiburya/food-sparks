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
@Getter
@Setter
@EqualsAndHashCode
public class Complexity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private ComplexityName complexityName;

    public enum ComplexityName {
        EASY("Легкий рівень складності"),
        MEDIUM("Середній рівень складності"),
        HARD("Важкий рівень складності");

        private final String value;

        ComplexityName(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
