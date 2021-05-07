package com.cyu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cyu.model.Person;
import com.cyu.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/user")
	public List<Person> findAllUser() {
		return userService.findAll();
		
	}
	
	@GetMapping("/user/{userId}")
	public Person findUser(@PathVariable(name = "userId") int userId) {
		
		return userService.findById(userId);
	}
	
	@PostMapping("/user")
	public Person createUser(@RequestBody Person user) {

		return userService.createUser(user);
		
	}
	
	@PutMapping("/user")
	public Person updateUser(@RequestBody Person user) {
		return userService.update(user);
	}
	
	@DeleteMapping("/user/{userId}")
	public String deleteUser(@PathVariable(name = "userId") int userId) {
		 userService.deleteById(userId);
		 return "userId: "+userId+" deleted";
	}
	
	@PostMapping("/verifybuyeruser")
	public Person verifyBuyerUser(@RequestBody Person user){
		
		//System.out.println("email:"+user.getEmail()+"password:"+user.getPassword());
		return userService.verifyBuyerUser(user.getEmail(), user.getPassword());
	}
	
	
	@PostMapping("/verifyadminuser")
	public Person verifyAdminUser(@RequestBody Person user){
		
		//System.out.println("email:"+user.getEmail()+"password:"+user.getPassword());
		return userService.verifyAdminUser(user.getEmail(), user.getPassword());
	}
	

}
