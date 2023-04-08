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
public class DishType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private DishTypeName dishTypeName;

    public enum DishTypeName {
        DESSERT("Десерт"),
        SOUP("Перші страви"),
        MAIN_DISH("Основна страва"),
        PASTRY("Випічка"),
        APPETIZER("Закуска");

        private final String value;

        DishTypeName(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
