package team.project.foodsparks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.project.foodsparks.model.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender,Long> {
}
