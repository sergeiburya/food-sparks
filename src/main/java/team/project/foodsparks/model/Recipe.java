package team.project.foodsparks.model;

import java.util.Map;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dish_name")
    private String dishName;
    @Enumerated(EnumType.STRING)
    private CuisineRegion cuisineRegion;
    @Enumerated(EnumType.STRING)
    private DishType dishType;
    @ElementCollection
    @MapKeyJoinColumn(name = "ingredient_id")
    @Column(name = "amount")
    private Map<Ingredient, Double> ingredientList;
    private boolean spiced;
    @Column(length = 5000)
    private String instructions;
    private Integer cookingTime;
    private Integer portions;
    private String imageUrl;
}
