package team.project.foodsparks.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shopping_carts")
public class ShoppingCart {
    @Id
    private Long id;
    @OneToMany
    @JoinTable(name = "shopping_carts_ingredients",
            joinColumns = @JoinColumn(name = "shopping_cart_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> ingredients;
    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != Hibernate.getClass(obj)) {
            return false;
        }
        ShoppingCart that = (ShoppingCart) obj;
        return getId() != null
                && Objects.equals(getId(), that.getId())
                && Objects.equals(getUser(), that.getUser())
                && Objects.equals(getIngredients(), that.getIngredients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ingredients, user);
    }

    @Override
    public String toString() {
        return "ShoppingCart{"
                + "id=" + id
                + ", tickets=" + ingredients
                + ", user=" + user + '}';
    }
}
