package com.LoqoApp.Models;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// create schema
@Document
public class Product {
	

	@Id // unique
	private String id;
	
	private String name;
	
	private String category;
	
	private double price;
	
	private boolean inStock;
	
	private double rating;
	
    private Date createdAt;
    
    

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean getInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Product(String id, String name, String category, double price, boolean inStock, double rating,
			Date createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.inStock = inStock;
		this.rating = rating;
		this.createdAt = createdAt;
	}
	
	public Product() {
		
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", inStock="
				+ inStock + ", rating=" + rating + ", createdAt=" + createdAt + "]";
	}
	
}
