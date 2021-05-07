package com.cyu.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cyu.model.Coupon;
import com.cyu.repository.CouponRepository;


@Service
public class CouponService {
	
	 @Autowired
	    private CouponRepository couponRepository;
	 
	 public List<Coupon> findAll() {
		 
		 LocalDate todaysDate= java.time.LocalDate.now();
		 String sTodaysDate=todaysDate.toString();
		   List<Coupon> coupons= couponRepository.findAll();
		   List<Coupon> filteredCoupons=new ArrayList<>();
		   
		   for(int i=0;i<coupons.size();i++) {
			   if(coupons.get(i).getEndDate().toString().compareTo(sTodaysDate)>=0
				 &&coupons.get(i).getStartDate().toString().compareTo(sTodaysDate)<=0) {
				   filteredCoupons.add(coupons.get(i));
			   }
		   }
		   return filteredCoupons;
	 }

 public Coupon findById(int couponId) {
		 
	 return couponRepository.findById(couponId).get();
	 }
 

 public Coupon save(Coupon coupon) {
	 
	 return couponRepository.save(coupon);
 }
 
 public void delete(int id) {
	 
	 couponRepository.deleteById(id);
 }
 
 
 public Coupon update(Coupon newCoupon) {
	 
	return save(newCoupon);
 }

public Coupon createCoupon(Coupon coupon) {
	
	if(couponRepository.couponFindByName(coupon.getName())>0) {
		throw new IllegalArgumentException("This coupon Name exsit. Try some other name");
	}
	
	return save(coupon);
}

}
