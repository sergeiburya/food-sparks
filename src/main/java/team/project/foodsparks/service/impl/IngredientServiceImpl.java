package team.project.foodsparks.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.Ingredient;
import team.project.foodsparks.model.Warehouse;
import team.project.foodsparks.repository.IngredientRepository;
import team.project.foodsparks.repository.WarehouseRepository;
import team.project.foodsparks.service.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;
    private final WarehouseRepository warehouseRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository,
                                 WarehouseRepository warehouseRepository) {
        this.ingredientRepository = ingredientRepository;
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        Warehouse warehouse = new Warehouse();
        warehouse.setIngredient(savedIngredient);
        warehouse.setAmount(0d);
        warehouseRepository.save(warehouse);
        return savedIngredient;
    }

    @Override
    public Optional<Ingredient> getById(Long id) {
        return ingredientRepository.findById(id);
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }
}
