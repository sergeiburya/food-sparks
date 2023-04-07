package team.project.foodsparks.service;

import java.util.List;
import java.util.Optional;
import team.project.foodsparks.model.DishType;

public interface DishTypeService {
    DishType add(DishType dishType);

    List<DishType> getAll();

    Optional<DishType> getById(Long id);

}
