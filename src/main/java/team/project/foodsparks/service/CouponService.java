package team.project.foodsparks.service;

import java.util.Optional;
import team.project.foodsparks.model.Coupon;

public interface CouponService {
    Coupon add(String userEmail);

    Coupon update(Coupon coupon);

    Optional<Coupon> getByValue(String couponValue);
}
