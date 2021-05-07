package com.cyu.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cyu.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String>{

	@Query("{ 'userId' : ?0 }")
	List<Order> findOrderByUserId(int userId);

}
