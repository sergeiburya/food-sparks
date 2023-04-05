package team.project.foodsparks.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.Gender;
import team.project.foodsparks.repository.GenderRepository;
import team.project.foodsparks.service.GenderService;

@Service
public class GenderServiceImpl implements GenderService {
    private final GenderRepository genderRepository;

    @Autowired
     public GenderServiceImpl(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @Override
    public Gender add(Gender gender) {
        return genderRepository.save(gender);
    }

    @Override
    public Gender getByName(String genderName) {
        return genderRepository.findByGenderName(Gender.GenderName.valueOf(genderName));
    }

    @Override
    public Optional<Gender> getById(Long id) {
        return genderRepository.findById(id);
    }
}
