package team.project.foodsparks.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products",
        uniqueConstraints = @UniqueConstraint(columnNames = "product_name"))
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String name;
    private BigDecimal price;
    private Integer amountInPackage;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product product = (Product) obj;
        return getId() != null
                && Objects.equals(getId(), product.getId())
                && Objects.equals(getName(), product.getName())
                && Objects.equals(getPrice(), product.getPrice())
                && Objects.equals(getAmountInPackage(), product.getAmountInPackage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, amountInPackage);
    }

    @Override
    public String toString() {
        return "Product{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", price=" + price
                + ", amountInPackage=" + amountInPackage
                + '}';
    }
}
