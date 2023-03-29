package team.project.foodsparks.service;

import java.util.Optional;
import team.project.foodsparks.model.VerificationToken;

public interface VerificationTokenService {
    VerificationToken add(VerificationToken verificationToken);

    void delete(VerificationToken verificationToken);

    Optional<VerificationToken> findTokenByValue(String tokenValue);
}
