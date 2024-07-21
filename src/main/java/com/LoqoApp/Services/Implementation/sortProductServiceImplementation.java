package com.LoqoApp.Services.Implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LoqoApp.Models.Product;
import com.LoqoApp.Repository.productRepository;
import com.LoqoApp.Services.sortProductServices;

@Service
public class sortProductServiceImplementation implements sortProductServices{
	
	@Autowired
	public productRepository productRepo;
	
	
	public List<Product> sortProductAscOrderPrice() {
		try {
			List<Product> product = productRepo.findAllByOrderByPriceAsc();
			return product;
			
		}catch(Exception err) {
			System.err.println("failed to get products sort by price ascending order!"+err.getMessage());
			throw err;
		}
	}
	
	public List<Product> sortProductDescOrderPrice() {
		try {
			List<Product> product = productRepo.findAllByOrderByPriceDesc();
			return product;
			
		}catch(Exception err) {
			System.err.println("failed to get products sort by price descending order!"+err.getMessage());
			throw err;
		}
	}
	
	public List<Product> sortProductAscOrderRating() {
		try {
			List<Product> product = productRepo.findAllByOrderByRatingAsc();
			return product;
			
		}catch(Exception err) {
			System.err.println("failed to get products sort by rating ascending order!"+err.getMessage());
			throw err;
		}
	}
	
	public List<Product>sortProductDescOrderRating() {
		try {
			List<Product> product = productRepo.findAllByOrderByRatingDesc();
			return product;
			
		}catch(Exception err) {
			System.err.println("failed to get products sort by rating descending order!"+err.getMessage());
			throw err;
		}
	}
	
	public List<Product>sortProductAscOrderdAt() {
		try {
			List<Product> product = productRepo.findAllByOrderByCreatedAtAsc();
			return product;
			
		}catch(Exception err) {
			System.err.println("failed to get products sort by CreatedAt ascending order!"+err.getMessage());
			throw err;
		}
	}
	
	public List<Product>sortProductDescOrderdAt() {
		try {
			List<Product> product = productRepo.findAllByOrderByCreatedAtDesc();
			return product;
			
		}catch(Exception err) {
			System.err.println("failed to get products sort by CreatedAt descending order!"+err.getMessage());
			throw err;
		}
	}
}
