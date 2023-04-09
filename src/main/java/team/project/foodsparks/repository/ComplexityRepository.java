package team.project.foodsparks.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.project.foodsparks.model.Complexity;

@Repository
public interface ComplexityRepository extends JpaRepository<Complexity, Long> {
    Optional<Complexity> findByComplexityName(Complexity.ComplexityName complexityName);
}
