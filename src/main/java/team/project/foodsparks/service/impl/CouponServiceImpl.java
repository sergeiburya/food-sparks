package team.project.foodsparks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.Coupon;
import team.project.foodsparks.repository.CouponRepository;
import team.project.foodsparks.service.CouponService;
import team.project.foodsparks.service.EmailService;
import team.project.foodsparks.util.CouponGenerator;

@Service
public class CouponServiceImpl implements CouponService {
    private final CouponRepository couponRepository;
    private final EmailService emailService;

    @Autowired
    public CouponServiceImpl(CouponRepository couponRepository,
                             EmailService emailService) {
        this.couponRepository = couponRepository;
        this.emailService = emailService;
    }

    @Override
    public Coupon add(String userEmail) {
        String couponCode = CouponGenerator.createRandomCode();
        Coupon coupon = new Coupon();
        coupon.setCouponValue(couponCode);
        coupon.setUserEmail(userEmail);
        coupon.setDiscountSize(20);
        Coupon savedCoupon = couponRepository.save(coupon);
        emailService.sendSimpleMessage(userEmail, "Your discount coupon",
                "Your coupon with discount 20% on your first order: " + couponCode
                        + "\n If you are not registered yet, then you need to register with"
                        + " this email: " + userEmail + " before use your coupon.");
        return savedCoupon;
    }
}
