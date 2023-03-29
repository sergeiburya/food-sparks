package team.project.foodsparks.util;

import java.util.Base64;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Component;
import team.project.foodsparks.model.VerificationToken;

@Component
public class VerificationTokenGenerator {
    private static final BytesKeyGenerator DEFAULT_TOKEN_GENERATOR = KeyGenerators
            .secureRandom(30);

    public VerificationToken createVerificationToken() {
        String tokenValue = new String(Base64.getUrlEncoder()
                .encode(DEFAULT_TOKEN_GENERATOR.generateKey()));
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(tokenValue);
        return verificationToken;
    }
}
