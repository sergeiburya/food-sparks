package team.project.foodsparks.service;

import team.project.foodsparks.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User add(User user);

    Optional<User> get(Long id);

    Optional<User> findByEmail(String email);

    List<User> findAll();
}
