package team.project.foodsparks.service;

import java.util.List;
import java.util.Optional;
import team.project.foodsparks.model.User;

public interface UserService {
    User add(User user);

    Optional<User> get(Long id);

    Optional<User> findByEmail(String email);

    List<User> findAll();

    void deleteUserById(Long id);

    void deleteByEmail(String email);
}
