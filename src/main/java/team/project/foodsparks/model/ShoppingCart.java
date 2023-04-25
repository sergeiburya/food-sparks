package team.project.foodsparks.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
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
    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> cartItemList;
    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private User user;
    @OneToOne
    private Coupon coupon;
}
