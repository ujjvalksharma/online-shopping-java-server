package com.cyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyu.model.Order;
import com.cyu.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public Order save(Order order) {
		return orderRepository.save(order);
	}

	public Order findById(String orderId) {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderId).get();
	}

	public List<Order> findOrderByUserId(int userId) {
		 return orderRepository.findOrderByUserId(userId);
		
	}
	
	public Order deleteOrder(String orderId) {
		Order deletedOrder= orderRepository.findById(orderId).get();
		orderRepository.deleteById(orderId);
		return deletedOrder;
	}
	

}
