package team.project.foodsparks.service.impl;

import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import team.project.foodsparks.exeption.AuthenticationException;
import team.project.foodsparks.model.Role;
import team.project.foodsparks.model.User;
import team.project.foodsparks.model.VerificationToken;
import team.project.foodsparks.service.AuthenticationService;
import team.project.foodsparks.service.EmailService;
import team.project.foodsparks.service.RoleService;
import team.project.foodsparks.service.ShoppingCartService;
import team.project.foodsparks.service.UserService;
import team.project.foodsparks.service.VerificationTokenService;
import team.project.foodsparks.util.VerificationTokenGenerator;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final VerificationTokenService verificationTokenService;
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public AuthenticationServiceImpl(UserService userService,
                                     RoleService roleService,
                                     PasswordEncoder passwordEncoder,
                                     EmailService emailService,
                                     VerificationTokenService verificationTokenService,
                                     ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
        this.verificationTokenService = verificationTokenService;
        this.shoppingCartService = shoppingCartService;
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
        user.setEmailConfirmed(true);
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
//        VerificationToken verificationToken
//                = VerificationTokenGenerator.createVerificationToken();
//        verificationToken.setUser(user);
//        verificationTokenService.add(verificationToken);
//        emailService.sendSimpleMessage(user.getEmail(), "Registration confirmation",
//                "Account with email: " + user.getEmail() + " has been successfully registered. "
//                        + "For confirm you registration use the link: "
//                        + "http://foodsparks.eu-central-1.elasticbeanstalk.com/verify?token="
//                        + verificationToken.getToken());
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
