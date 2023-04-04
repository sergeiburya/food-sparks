package team.project.foodsparks.util;

import java.util.Base64;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import team.project.foodsparks.model.VerificationToken;

public class VerificationTokenGenerator {
    private static final BytesKeyGenerator DEFAULT_TOKEN_GENERATOR = KeyGenerators
            .secureRandom(30);

    private VerificationTokenGenerator() {
    }

    public static VerificationToken createVerificationToken() {
        String tokenValue = new String(Base64.getUrlEncoder()
                .encode(DEFAULT_TOKEN_GENERATOR.generateKey()));
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(tokenValue);
        return verificationToken;
    }
}
