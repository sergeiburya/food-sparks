package team.project.foodsparks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.project.foodsparks.model.CuisineRegion;

@Repository
public interface CuisineRegionRepository extends JpaRepository<CuisineRegion, Long> {
}
