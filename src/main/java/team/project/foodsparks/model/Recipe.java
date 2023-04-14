package team.project.foodsparks.model;

import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    private String title;
    private String subtitle;
    @ManyToOne
    private CuisineRegion cuisineRegion;
    @ManyToOne
    private DishType dishType;
    @ElementCollection
    @MapKeyJoinColumn(name = "product_id")
    @Column(name = "amount")
    private Map<Product, Integer> productList;
    private boolean spiced;
    @ElementCollection
    private List<String> instructions;
    private Integer cookingTime;
    private Integer portions;
    private String imageUrl;
    @ManyToOne
    private Complexity complexity;
}
