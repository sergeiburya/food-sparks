package team.project.foodsparks.service.impl;

import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import team.project.foodsparks.event.UserRegistrationEventPublisher;
import team.project.foodsparks.exeption.AuthenticationException;
import team.project.foodsparks.model.Role;
import team.project.foodsparks.model.User;
import team.project.foodsparks.model.VerificationToken;
import team.project.foodsparks.service.AuthenticationService;
import team.project.foodsparks.service.RoleService;
import team.project.foodsparks.service.UserService;
import team.project.foodsparks.service.VerificationTokenService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenService verificationTokenService;
    private final UserRegistrationEventPublisher userRegistrationEventPublisher;

    @Autowired
    public AuthenticationServiceImpl(UserService userService,
                                     RoleService roleService,
                                     PasswordEncoder passwordEncoder,
                                     VerificationTokenService verificationTokenService,
                                     UserRegistrationEventPublisher eventPublisher) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.verificationTokenService = verificationTokenService;
        this.userRegistrationEventPublisher = eventPublisher;
    }

    @Override
    public User register(String email, String password, String firstName, String lastName) {
        Role role = roleService.getByName(Role.RoleName.USER.name());
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(Set.of(role));
        userService.add(user);
        userRegistrationEventPublisher.publishUserRegistrationEvent(user.getId());
        return user;
    }

    @Override
    public User login(String login, String password) throws AuthenticationException {
        Optional<User> user = userService.findByEmail(login);
        if (user.isEmpty() || !passwordEncoder.matches(password, user.get().getPassword())) {
            throw new AuthenticationException("Incorrect username or password!!!");
        }
        User currentUser = user.get();
        if (!currentUser.isEmailConfirmed()) {
            throw new AuthenticationException("Email isn't confirmed. "
                    + "Check your email for confirmation link.");
        }
        return currentUser;
    }

    public String verifyEmail(String tokenValue) {
        VerificationToken verificationToken = verificationTokenService
                .findTokenByValue(tokenValue).orElseThrow(
                        () -> new RuntimeException("Token isn't valid"));
        User user = userService.findByEmail(verificationToken.getUser().getEmail()).get();
        user.setEmailConfirmed(true);
        userService.add(user);
        verificationTokenService.delete(verificationToken);
        return "Email confirmed!";
    }

}
