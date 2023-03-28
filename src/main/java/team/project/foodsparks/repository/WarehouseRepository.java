package team.project.foodsparks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.project.foodsparks.model.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
