package team.project.foodsparks.model;

import java.util.Map;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "shopping_carts")
public class ShoppingCart {
    @Id
    private Long id;
    @ElementCollection
    @MapKeyJoinColumn(name = "product_id")
    @Column(name = "product_amount")
    private Map<Product, Integer> productAmount;
    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private User user;
}
