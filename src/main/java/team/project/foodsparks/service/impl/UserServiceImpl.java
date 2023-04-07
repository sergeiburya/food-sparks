package team.project.foodsparks.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.User;
import team.project.foodsparks.repository.ShoppingCartRepository;
import team.project.foodsparks.repository.UserRepository;
import team.project.foodsparks.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ShoppingCartRepository shoppingCartRepository) {
        this.userRepository = userRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {
        shoppingCartRepository.deleteByUser_Id(id);
        userRepository.deleteById(id);
    }

    @Override
    public void deleteByEmail(String email) {
        shoppingCartRepository.deleteByUser_Email(email);
        userRepository.deleteByEmail(email);
    }
}
