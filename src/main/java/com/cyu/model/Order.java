package com.cyu.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "orders")
public class Order {
	
	@Id
	String _id;
	
	List<Product> products;
	
	@JsonProperty("shippingAddr")
	Address shippingAddr;
	
     double totalAmount;
	
	int userId;
	
	public Order() {
		
	}

	
	public Order(String _id, List<Product> products, Address shippingAddr, int totalAmount, int userId) {
		super();
		this._id = _id;
		this.products = products;
		this.shippingAddr = shippingAddr;
		this.totalAmount = totalAmount;
		this.userId = userId;
	}


	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Address getShippingAddr() {
		return shippingAddr;
	}

	public void setShippingAddr(Address shippingAddr) {
		this.shippingAddr = shippingAddr;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "Order [_id=" + _id + ", products=" + products + ", shippingAddr=" + shippingAddr + ", totalAmount="
				+ totalAmount + ", userId=" + userId + "]";
	}

	

}
