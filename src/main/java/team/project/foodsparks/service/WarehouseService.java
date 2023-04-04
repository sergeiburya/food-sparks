package team.project.foodsparks.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.Warehouse;

@Service
public interface WarehouseService {
    Warehouse add(Warehouse warehouse);

    List<Warehouse> getAll();

    Optional<Warehouse> getById(Long id);

    Warehouse increaseAmountOfProduct(Long id, Integer amount);

    Warehouse decreaseAmountOfProduct(Long id, Integer amount);

}
