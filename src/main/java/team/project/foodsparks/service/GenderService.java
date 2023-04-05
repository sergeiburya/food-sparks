package team.project.foodsparks.service;

import java.util.Optional;
import team.project.foodsparks.model.Gender;

public interface GenderService {
    Gender add(Gender gender);

    Gender getByName(String genderName);

    Optional<Gender> getById(Long id);
}
