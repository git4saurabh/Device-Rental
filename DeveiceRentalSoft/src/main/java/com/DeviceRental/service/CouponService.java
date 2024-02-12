package com.DeviceRental.service;

import com.DeviceRental.model.Coupon;
import com.DeviceRental.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    public Coupon findByCode(String code) {
        return couponRepository.findByCode(code);
    }

    public boolean isCouponValid(String code) {
        Coupon coupon = findByCode(code);
        return coupon != null && !coupon.isExpired() && coupon.getTimesUsed() < coupon.getUsageLimit();
    }

    public double applyDiscount(double totalPrice, String code) {
        Coupon coupon = findByCode(code);
        if (coupon != null && !coupon.isExpired() && coupon.getTimesUsed() < coupon.getUsageLimit()) {
            coupon.setTimesUsed(coupon.getTimesUsed() + 1);
            couponRepository.save(coupon);
            return totalPrice - coupon.getDiscountAmount();
        }
        return totalPrice;
    }

    public Coupon createCoupon(String code, double discountAmount, LocalDate expirationDate, int usageLimit) {
        Coupon coupon = new Coupon();
        coupon.setCode(code);
        coupon.setDiscountAmount(discountAmount);
//        coupon.setExpirationDate(expirationDate);
        coupon.setUsageLimit(usageLimit);
        coupon.setTimesUsed(0);
        return couponRepository.save(coupon);
    }

    public void save(Coupon coupon) {

    }
}
