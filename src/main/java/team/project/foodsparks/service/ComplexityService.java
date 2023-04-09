package team.project.foodsparks.service;

import java.util.List;
import java.util.Optional;
import team.project.foodsparks.model.Complexity;

public interface ComplexityService {
    Complexity add(Complexity complexity);

    List<Complexity> getAll();

    Optional<Complexity> getById(Long id);

    Optional<Complexity> getByName(Complexity.ComplexityName complexityName);
}
