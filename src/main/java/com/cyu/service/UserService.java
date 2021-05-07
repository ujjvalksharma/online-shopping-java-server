package com.cyu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cyu.repository.UserRepository;
import com.cyu.model.Person;
@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<Person> findAll() {
		return userRepository.findAll();
		
		
	}
	
	public Person findById(int userId) {
		
		Optional<Person> optinalEntityUser =  userRepository.findById(userId);
		Person user = optinalEntityUser.get();
		 
		return user;
		
	}
	
	public Person createUser(Person user) {
		
		if(countOfBuyerEmail(user.getEmail())>=1) {
		 throw new IllegalArgumentException("EmailID is already in use");
		}
		
		 return userRepository.save(user);
		
	}
	
	
	
	public Person update(Person user) {
	//	User oldUser= findById(userId);
	//	user.setId(userId);
		return userRepository.save(user);
		
	}
	
	public void deleteById(int userId) {
		
		 userRepository.deleteById(userId);
		 
	}
	
	public void delete(Person user) {
		 userRepository.delete(user);
	}

	public Person verifyBuyerUser(String email, String password)  {
	
		List<Person> users= userRepository.verifyBuyerUser(email,password);
		System.out.println("size:"+users.size());
		if(users.size()<=0){
			throw new IllegalArgumentException("Invalid credentials!!");
		}
		
		if(users.size()>1){
			throw new IllegalArgumentException("Multiple user exist");
		}
		return users.get(0);
		
	}
	
	public Person verifyAdminUser(String email, String password)  {
		
		List<Person> users= userRepository.verifyAdminUser(email,password);
		System.out.println("size:"+users.size());
		if(users.size()<=0){
			throw new IllegalArgumentException("Incorrect credentials");
		}
		
		if(users.size()>1){
			throw new IllegalArgumentException("Multiple user exist");
		}
		return users.get(0);
		
	}
	
	public int countOfBuyerEmail(String email) {
		 int count= userRepository.isUserEmailPresent(email);
		 return count;
		
	}

	
}
