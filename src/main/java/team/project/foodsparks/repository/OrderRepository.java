package team.project.foodsparks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.project.foodsparks.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
