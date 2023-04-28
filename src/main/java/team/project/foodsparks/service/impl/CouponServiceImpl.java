package team.project.foodsparks.service.impl;

import java.io.IOException;
import java.util.Optional;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.foodsparks.exception.DataProcessingException;
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
    public Coupon add(String userEmail) throws MessagingException, IOException {
        if (couponRepository.findCouponByUserEmail(userEmail).isPresent()) {
            throw new DataProcessingException("Ви вже отримали ваш купон для знижки.");
        }
        String couponCode = CouponGenerator.createRandomCode();
        Coupon coupon = new Coupon();
        coupon.setCouponValue(couponCode);
        coupon.setUserEmail(userEmail);
        coupon.setDiscountSize(20);
        Coupon savedCoupon = couponRepository.save(coupon);
        emailService.sendHtmlCoupon(userEmail, couponCode);
        return savedCoupon;
    }

    @Override
    public Coupon update(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public Optional<Coupon> getByValue(String couponValue) {
        return couponRepository.findCouponByCouponValue(couponValue);
    }
}
