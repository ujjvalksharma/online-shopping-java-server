package com.cyu.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cyu.model.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Integer> {

	 @Query(  value = "select Count(*) from Coupon where name=?1",
			  nativeQuery = true)
	public int couponFindByName(String name);
	 

/*	 @Query(  value = "select * from COUPON where end_date>=?1::date and start_date<=?1::date ",
	  nativeQuery = true)
	 public List<Coupon> findAll(String sTodaysDate);
	
*/

}
