package team.project.foodsparks.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    @JoinTable(name = "orders_ingredients",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> ingredients;
    @Column(name = "order_time")
    private LocalDateTime orderTime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != getClass()) {
            return false;
        }
        Order order = (Order) obj;
        return getId() != null
                && Objects.equals(getId(), order.getId())
                && Objects.equals(getIngredients(), order.getIngredients())
                && Objects.equals(getUser(), order.getUser())
                && Objects.equals(getOrderTime(), order.getOrderTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ingredients, orderTime, user);
    }

    @Override
    public String toString() {
        return "Order{"
                + "id=" + id
                + ", ingredients=" + ingredients
                + ", orderTime=" + orderTime
                + ", user=" + user + '}';
    }
}
