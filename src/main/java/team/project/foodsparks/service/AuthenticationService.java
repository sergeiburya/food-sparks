package team.project.foodsparks.service;

import team.project.foodsparks.exception.AuthenticationException;
import team.project.foodsparks.model.User;

public interface AuthenticationService {
    User register(String email, String password, String firstName, String lastName)
            throws AuthenticationException;

    User login(String email, String password) throws AuthenticationException;

    String verifyEmail(String tokenValue);
}
