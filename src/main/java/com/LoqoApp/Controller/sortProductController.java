package com.LoqoApp.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.LoqoApp.Models.Product;
import com.LoqoApp.Services.sortProductServices;


@RestController
@RequestMapping("/api/sort")
public class sortProductController {
	
	@Autowired
	private sortProductServices product; // object sortService interface
	
	
	// find all products Ascending order price
	
	@GetMapping("/product-by/price-asc")
	public ResponseEntity<?> sortProductPriceByAsc(){
		try {
			List<Product> products = this.product.sortProductAscOrderPrice();
			return new ResponseEntity<>(products,HttpStatus.OK);
		}catch(Exception err) {
			System.out.println("Failed to get product by price ascending order!"+err.getMessage());
			String errorMessage = "faield to get products by price ascending order!";
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// find all products Descending order price
	
	@GetMapping("/product-by/price-desc")
	public ResponseEntity<?> sortProductPriceByDesc(){
		try {
			List<Product> products = this.product.sortProductDescOrderPrice();
			return new ResponseEntity<>(products,HttpStatus.OK);
		}catch(Exception err) {
			System.out.println("Failed to get product by price Descending order!"+err.getMessage());
			String errorMessage = "faield to get products by price Descending order!";
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// find all products Ascending order rating
	
	@GetMapping("/product-by/rating-asc")
	public ResponseEntity<?> sortProductRatingAsc(){
		try {
			List<Product> products = this.product.sortProductAscOrderRating();
			return new ResponseEntity<>(products,HttpStatus.OK);
		}catch(Exception err) {
			System.out.println("Failed to get product by rating Ascending order!"+err.getMessage());
			String errorMessage = "faield to get products by rating Ascending order!";
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// find all products Descending order rating
	
	@GetMapping("/product-by/rating-desc")
	public ResponseEntity<?> sortProductRatingDesc(){
		try {
			List<Product> products = this.product.sortProductDescOrderRating();
			return new ResponseEntity<>(products,HttpStatus.OK);
		}catch(Exception err) {
			System.out.println("Failed to get product by rating Descending order!"+err.getMessage());
			String errorMessage = "faield to get products by rating Descending order!";
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// find all products Ascending order createdAr
	
	@GetMapping("/product-by/createdAt-asc")
	public ResponseEntity<?> sortProductCreatedAtAsc(){
		try {
			List<Product> products = this.product.sortProductAscOrderdAt();
			return new ResponseEntity<>(products,HttpStatus.OK);
		}catch(Exception err) {
			System.out.println("Failed to get product by createdAt Ascending order!"+err.getMessage());
			String errorMessage = "faield to get products by createdAt Ascending order!";
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// find all products Descending order createdAt
	
	@GetMapping("/product-by/createdAt-desc")
	public ResponseEntity<?> sortProductCreatedAtDesc(){
		try {
			List<Product> products = this.product.sortProductDescOrderdAt();
			return new ResponseEntity<>(products,HttpStatus.OK);
		}catch(Exception err) {
			System.out.println("Failed to get product by createdAt Descending order!"+err.getMessage());
			String errorMessage = "faield to get products by createdAt Descending order!";
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
