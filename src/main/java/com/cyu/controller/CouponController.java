package com.cyu.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cyu.model.Coupon;
import com.cyu.service.CouponService;


@RestController
@CrossOrigin(origins = "*")
public class CouponController {
	
	 @Autowired
	CouponService couponService;
	
	@PostMapping("/coupon")
	public Coupon createCoupon(@RequestBody Coupon coupon) {
		
		System.out.println(coupon);
		return couponService.createCoupon(coupon);
		
	}
	@DeleteMapping("/coupon/{id}")
	public String deleteCoupon(@PathVariable(name = "id") int id) {
		
		couponService.delete(id);
		return "CouponId: "+id+" deleted";
	}
	
	@GetMapping("/coupon")
	public List<Coupon> findAllCoupon() {
		

		return couponService.findAll();
		
	}
	@GetMapping("/coupon/{id}")
	public Coupon findCouponById(@PathVariable(name = "id") int couponId) {
		
		return couponService.findById(couponId);
		
	}
	@PutMapping("/coupon")
	public Coupon updateCoupon(@RequestBody Coupon newCoupon) {
		
		return couponService.update(newCoupon);
		
	}
	

}
