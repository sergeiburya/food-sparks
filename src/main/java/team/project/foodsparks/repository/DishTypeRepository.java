package team.project.foodsparks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.project.foodsparks.model.DishType;

public interface DishTypeRepository extends JpaRepository<DishType,Long> {

}
