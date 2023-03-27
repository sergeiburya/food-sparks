package team.project.foodsparks.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.Warehouse;
import team.project.foodsparks.repository.WarehouseRepository;
import team.project.foodsparks.service.WarehouseService;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    private final WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public List<Warehouse> getAll() {
        return warehouseRepository.findAll();
    }

    @Override
    public Optional<Warehouse> getById(Long id) {
        return warehouseRepository.findById(id);
    }

    @Override
    public Warehouse increaseAmountOfIngredient(Long id, Double amount) {
        Warehouse warehouseById = warehouseRepository.getById(id);
        warehouseById.setAmount(warehouseById.getAmount() + amount);
        return warehouseRepository.save(warehouseById);
    }

    @Override
    public Warehouse decreaseAmountOfIngredient(Long id, Double amount) {
        Warehouse warehouseById = warehouseRepository.getById(id);
        Double amountOfIngredient = warehouseById.getAmount();
        if (amountOfIngredient >= amount) {
            warehouseById.setAmount(warehouseById.getAmount() - amount);
        } else {
            throw new RuntimeException("Not enough amount of ingredient: "
                    + warehouseById.getIngredient().getName());
        }
        return warehouseRepository.save(warehouseById);
    }
}
