package com.cyu.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cyu.model.Person;


@Repository
public interface UserRepository extends JpaRepository<Person, Integer> {
	
	  @Query(  value = "select * from Person where email=?1 and password=?2 and type='BUYER' ",
			  nativeQuery = true)
	  public List<Person> verifyBuyerUser(String email, String password);
	  
	  @Query(  value = "select * from Person where email=?1 and password=?2 and type='ADMIN' ",
			  nativeQuery = true)
	  public List<Person> verifyAdminUser(String email, String password);
	  

	  @Query(  value = "select Count(*) from Person where email=?1 and type='BUYER' ",
			  nativeQuery = true)
	  public int isUserEmailPresent(String email);
	  
	  
	  @Query(  value = "select * from Person where email=?1 and password=?2",
			  nativeQuery = true)
	  public  Person findUserByEmail(String email, String password);
	
	  

}


