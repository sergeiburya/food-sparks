package team.project.foodsparks.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
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
    @ElementCollection
    @MapKeyJoinColumn(name = "product_id")
    @Column(name = "amount")
    private Map<Product, Integer> productAmount;
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
                && Objects.equals(getProductAmount(), order.getProductAmount())
                && Objects.equals(getUser(), order.getUser())
                && Objects.equals(getOrderTime(), order.getOrderTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productAmount, orderTime, user);
    }

    @Override
    public String toString() {
        return "Order{"
                + "id=" + id
                + ", productAmount=" + productAmount
                + ", orderTime=" + orderTime
                + ", user=" + user + '}';
    }
}
