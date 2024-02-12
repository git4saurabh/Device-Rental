package com.DeviceRental.controller;

import com.DeviceRental.model.Coupon;
import com.DeviceRental.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/coupons12")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/create")
    public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon) {
        Coupon createdCoupon = couponService.createCoupon(coupon.getCode(), coupon.getDiscountAmount(), coupon.getExpirationDate(), coupon.getUsageLimit());
        return ResponseEntity.ok(createdCoupon);
    }

    @PutMapping("/{code}/update-expiration")
    public ResponseEntity<?> updateCouponExpiration(@PathVariable String code, @RequestParam LocalDate expirationDate) {
        Coupon coupon = couponService.findByCode(code);
        if (coupon != null) {
            coupon.setExpirationDate(expirationDate);
            couponService.save(coupon);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Other methods remain the same
}
