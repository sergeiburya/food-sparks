package team.project.foodsparks.service;

import java.io.IOException;
import java.util.Optional;
import javax.mail.MessagingException;
import team.project.foodsparks.model.Coupon;

public interface CouponService {
    Coupon add(String userEmail) throws MessagingException, IOException;

    Coupon update(Coupon coupon);

    Optional<Coupon> getByValue(String couponValue);
}
