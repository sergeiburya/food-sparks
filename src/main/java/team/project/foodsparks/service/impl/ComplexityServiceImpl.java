package team.project.foodsparks.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.Complexity;
import team.project.foodsparks.repository.ComplexityRepository;
import team.project.foodsparks.service.ComplexityService;

@Service
public class ComplexityServiceImpl implements ComplexityService {
    private final ComplexityRepository complexityRepository;

    @Autowired
    public ComplexityServiceImpl(ComplexityRepository complexityRepository) {
        this.complexityRepository = complexityRepository;
    }

    @Override
    public Complexity add(Complexity complexity) {
        return complexityRepository.save(complexity);
    }

    @Override
    public List<Complexity> getAll() {
        return complexityRepository.findAll();
    }

    @Override
    public Optional<Complexity> getById(Long id) {
        return complexityRepository.findById(id);
    }

    @Override
    public Optional<Complexity> getByName(Complexity.ComplexityName complexityName) {
        return complexityRepository.findByComplexityName(complexityName);
    }
}
