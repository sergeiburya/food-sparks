package team.project.foodsparks.service;

import team.project.foodsparks.exeption.AuthenticationException;
import team.project.foodsparks.model.User;

public interface AuthenticationService {
    User register(String email, String password, String firstName, String lastName);

    User login(String email, String password) throws AuthenticationException;

    String verifyEmail(String tokenValue);
}
