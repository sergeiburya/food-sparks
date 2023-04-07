package team.project.foodsparks.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import team.project.foodsparks.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "from User u join fetch u.roles where u.email = :email")
    Optional<User> findByEmail(String email);

    void deleteByEmail(String email);
}
