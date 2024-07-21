package com.LoqoApp.Services;

import java.util.List;
import com.LoqoApp.Models.Product;

public interface sortProductServices {
	
	public List<Product> sortProductAscOrderPrice();// Sort by price in ascending order
	
	public List<Product> sortProductDescOrderPrice();// Sort by price in descending order
	
	public List<Product> sortProductAscOrderRating();// Sort by rating in ascending order
	
	public List<Product> sortProductDescOrderRating();// Sort by rating in descending order
	
	public List<Product> sortProductAscOrderdAt();// Sort by created date in ascending order
	
	public List<Product> sortProductDescOrderdAt();// Sort by created date in descending order

}
