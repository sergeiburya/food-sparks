package team.project.foodsparks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.project.foodsparks.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
