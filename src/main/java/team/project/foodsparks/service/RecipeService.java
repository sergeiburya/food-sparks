package team.project.foodsparks.service;

import java.util.Map;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.Recipe;

@Service
public interface RecipeService {
    Recipe save(Recipe recipe);

    Page<Recipe> findAll(Map<String,String> params,
                         PageRequest pageRequest);

    Optional<Recipe> getById(Long id);
}
