package team.project.foodsparks.service;

import java.util.List;
import java.util.Optional;
import team.project.foodsparks.model.Ingredient;

public interface IngredientService {
    Ingredient save(Ingredient ingredient);

    Optional<Ingredient> getById(Long id);

    Optional<Ingredient> getByName(String name);

    List<Ingredient> getAll();
}
