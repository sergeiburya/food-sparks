package team.project.foodsparks.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.CuisineRegion;
import team.project.foodsparks.repository.CuisineRegionRepository;
import team.project.foodsparks.service.CuisineRegionService;

@Service
public class CuisineRegionServiceImpl implements CuisineRegionService {
    private final CuisineRegionRepository cuisineRegionRepository;

    public CuisineRegionServiceImpl(CuisineRegionRepository cuisineRegionRepository) {
        this.cuisineRegionRepository = cuisineRegionRepository;
    }

    @Override
    public CuisineRegion add(CuisineRegion cuisineRegion) {
        return cuisineRegionRepository.save(cuisineRegion);
    }

    @Override
    public List<CuisineRegion> getAll() {
        return cuisineRegionRepository.findAll();
    }

    @Override
    public Optional<CuisineRegion> getById(Long cuisineRegionId) {
        return cuisineRegionRepository.findById(cuisineRegionId);
    }
}
