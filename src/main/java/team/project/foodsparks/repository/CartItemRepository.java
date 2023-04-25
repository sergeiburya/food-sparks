package team.project.foodsparks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.project.foodsparks.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
