package team.project.foodsparks.service;

import java.util.List;
import java.util.Optional;
import team.project.foodsparks.model.CuisineRegion;

public interface CuisineRegionService {
    CuisineRegion add(CuisineRegion cuisineRegion);

    List<CuisineRegion> getAll();

    Optional<CuisineRegion> getById(Long cuisineRegionId);
}
