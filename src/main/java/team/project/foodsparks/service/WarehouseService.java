package team.project.foodsparks.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.Warehouse;

@Service
public interface WarehouseService {
    List<Warehouse> getAll();

    Optional<Warehouse> getById(Long id);

    Warehouse increaseAmountOfIngredient(Long id, Double amount);

    Warehouse decreaseAmountOfIngredient(Long id, Double amount);
}
