package team.project.foodsparks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.project.foodsparks.model.ShoppingCart;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    void deleteByUser_Email(String email);

    void deleteByUser_Id(Long id);
}
