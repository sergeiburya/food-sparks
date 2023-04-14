package team.project.foodsparks.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.project.foodsparks.model.Coupon;
import team.project.foodsparks.service.CouponService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/coupons")
public class CouponController {
    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PutMapping("/new")
    public Coupon createNewCoupon(@RequestParam String userEmail) {
        return couponService.add(userEmail);
    }
}
