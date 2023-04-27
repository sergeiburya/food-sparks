package team.project.foodsparks.event;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import team.project.foodsparks.exception.DataProcessingException;
import team.project.foodsparks.model.Address;
import team.project.foodsparks.model.User;
import team.project.foodsparks.model.VerificationToken;
import team.project.foodsparks.service.AddressService;
import team.project.foodsparks.service.EmailService;
import team.project.foodsparks.service.ShoppingCartService;
import team.project.foodsparks.service.UserService;
import team.project.foodsparks.service.VerificationTokenService;
import team.project.foodsparks.util.VerificationTokenGenerator;

import java.io.IOException;

@Component
public class UserRegistrationEventListener implements ApplicationListener<UserRegistrationEvent> {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final VerificationTokenService verificationTokenService;
    private final EmailService emailService;
    private final AddressService addressService;

    public UserRegistrationEventListener(UserService userService,
                                         ShoppingCartService shoppingCartService,
                                         VerificationTokenService verificationTokenService,
                                         EmailService emailService,
                                         AddressService addressService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.verificationTokenService = verificationTokenService;
        this.emailService = emailService;
        this.addressService = addressService;
    }

    @Override
    @Transactional
    public void onApplicationEvent(UserRegistrationEvent event) {
        User user = userService.get(event.getUserId()).get();
        shoppingCartService.registerNewShoppingCart(user);
        Address address = new Address();
        address.setUser(user);
        addressService.add(address);
        VerificationToken verificationToken
                = VerificationTokenGenerator.createVerificationToken();
        verificationToken.setUser(user);
        verificationTokenService.add(verificationToken);
        try {
            emailService.sendHtmlPage(user.getEmail(),"Registration confirmation",
                    verificationToken.getToken());
        } catch (MessagingException e) {
            throw new DataProcessingException("Can't send html page");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
