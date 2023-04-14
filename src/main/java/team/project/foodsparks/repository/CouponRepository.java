package team.project.foodsparks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.project.foodsparks.model.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
