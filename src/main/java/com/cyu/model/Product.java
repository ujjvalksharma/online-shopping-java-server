package com.cyu.model;

public class Product {

	 int id;
	 double price;
	 int quantity;
     String title;
     String category;
     String description;
     String image;
     
     
     public Product(){
    	 
     }


	public Product(int id, double price, int quantity, String title, String category, String description, String image) {
		super();
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.title = title;
		this.category = category;
		this.description = description;
		this.image = image;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", quantity=" + quantity + ", title=" + title + ", category="
				+ category + ", description=" + description + ", image=" + image + "]";
	}

	
	
    	 
}
