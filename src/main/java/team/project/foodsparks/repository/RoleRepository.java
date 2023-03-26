package team.project.foodsparks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.project.foodsparks.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String role);
}
