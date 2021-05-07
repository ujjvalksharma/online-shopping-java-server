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

import com.cyu.model.Order;
import com.cyu.service.OrderService;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/user/{userId}/order")
	public Order createOrder
	 (@PathVariable("userId") int userId
			,@RequestBody Order order) {
		System.out.println(order);
		System.out.println("userId:"+userId);
		order.setUserId(userId);
		return orderService.save(order);
		
		
	}
	@GetMapping("/order/{orderId}")
	public Order getOrderById
	 (@PathVariable("orderId") String orderId) {

		return orderService.findById(orderId);
		
	}
	
	@GetMapping("/user/{userId}/order")
	public List<Order> getOrderByUserId
	 (@PathVariable("userId") int userId) {

		return orderService.findOrderByUserId(userId);
		
	}
	
	
	@PutMapping("/order")
	public Order updateOrder(@RequestBody Order order) {
		return orderService.save(order);
	}
	
	
	@DeleteMapping("/order/{orderId}")
	public Order deleteOrder(@PathVariable("orderId") String orderId) {
		
		return orderService.deleteOrder(orderId);
	}

}
