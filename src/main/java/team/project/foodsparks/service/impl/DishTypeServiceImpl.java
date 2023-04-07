package team.project.foodsparks.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.DishType;
import team.project.foodsparks.repository.DishTypeRepository;
import team.project.foodsparks.service.DishTypeService;

@Service
public class DishTypeServiceImpl implements DishTypeService {
    private final DishTypeRepository dishTypeRepository;

    @Autowired
    public DishTypeServiceImpl(DishTypeRepository dishTypeRepository) {
        this.dishTypeRepository = dishTypeRepository;
    }

    @Override
    public DishType add(DishType dishType) {
        return dishTypeRepository.save(dishType);
    }

    @Override
    public List<DishType> getAll() {
        return dishTypeRepository.findAll();
    }

    @Override
    public Optional<DishType> getById(Long id) {
        return dishTypeRepository.findById(id);
    }
}
