package com.LoqoApp.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.LoqoApp.Models.Product;
import com.LoqoApp.Services.filterProductService;

@RestController
@RequestMapping("/api/filter")
public class filterProductController {
	
	@Autowired
	private filterProductService filterProduct;
	
	@GetMapping("/product/by-category")
	public ResponseEntity<?> filterProductByCategory(@RequestParam String category){

		try {
			List<Product> productCategory = this.filterProduct.filterByCategory(category);
			return new ResponseEntity<>(productCategory,HttpStatus.OK);
			
		}catch(Exception error) {
			System.err.println("Failed to get product by category!"+error.getMessage());
			String errorMessage = "Failed to get product by category!";
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/product/by-max")
	public ResponseEntity<?> filterAllProductByMaxPrice(@RequestParam Double price){
		try {
			List<Product> products = this.filterProduct.filterByMaxPrice(price);
			return new ResponseEntity<>(products,HttpStatus.OK);
		}catch(Exception err) {
			System.err.println("Failed to get all products by max price"+err.getMessage());
			String errorMessage = "Failed to get product filter by max price";
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/product/by-min")
	public ResponseEntity<?> filterAllProductsByMinPrice(@RequestParam Double price){
		try {
			List<Product> products = this.filterProduct.filterByMiniPrice(price);
			return new ResponseEntity<>(products,HttpStatus.OK);
		}catch(Exception err) {
			System.err.println("Failed to get all products by min price"+err.getMessage());
			String errorMessage = "Failed to get product filter by min price";
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("product/inStock")
	public ResponseEntity<?> getProductsByInStock(@RequestParam Boolean value){
		try {
			List<Product> products = this.filterProduct.filterByInStock(value);
			return new ResponseEntity<>(products,HttpStatus.OK);
		}catch(Exception err) {
			System.err.println("Failed to get all products by InStock"+err.getMessage());
			String errorMessage = "Failed to get product filter by InStock";
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// not working 
	
	@GetMapping("prpoduct/category/instock")
	public ResponseEntity<?> filterProductsByCategoryAndInStock(
			@RequestParam String category,
			@RequestParam Boolean value){
		
		try {
			List<Product> products = this.filterProduct.filterByProductCategoryInStock(category, value);
			return new ResponseEntity<>(products,HttpStatus.OK);
		}catch(Exception err) {
			System.err.println("Failed to get all products by products category and  InStock"+err.getMessage());
			String errorMessage = "Failed to get product filter by category and  InStock";
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// not working
	
	@GetMapping("product/expensive")
	public ResponseEntity<?> getProductsExpensive(){
		try {
			Product products = this.filterProduct.filterMaximumPriceProduct();
			return new ResponseEntity<>(products,HttpStatus.OK);
		}catch(Exception err) {
			System.err.println("Failed to get expensive products"+err.getMessage());
			String errorMessage = "Failed to get more expensive product";
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("product/cheaper")
	public ResponseEntity<?> getProductsCheaper(){
		try {
			Product products = this.filterProduct.filterMinimumPriceProduct();
			return new ResponseEntity<>(products,HttpStatus.OK);
		}catch(Exception err) {
			System.err.println("Failed to get cheaper products"+err.getMessage());
			String errorMessage = "Failed to get more cheaper product";
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("product/between/min-max-price")
	public ResponseEntity<?> getProductsBetweenMinAndMaxPrice(
			@RequestParam Double minPrice,
			@RequestParam Double maxPrice){
		
		try {
			List<Product> products = this.filterProduct.filterMinRangeToMaxRangeProduct(minPrice, maxPrice);
			return new ResponseEntity<>(products,HttpStatus.OK);
		}catch(Exception err) {
			System.err.println("Failed to get all products by price between minimum and maximum"+err.getMessage());
			String errorMessage = "Failed to get product filter by price between minimum and maximum";
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("product/category/maxPrice")
	public ResponseEntity<?> getProductsCategoryMaxPrice(
			@RequestParam String category,
			@RequestParam Double maxPrice){
		
		try {
			List<Product> products = this.filterProduct.filterProductCategoryMaximumRange(category,maxPrice);
			return new ResponseEntity<>(products,HttpStatus.OK);
		}catch(Exception err) {
			System.err.println("Failed to get all products category by maximum price"+err.getMessage());
			String errorMessage = "Failed to get product categoryfilter by maximum price";
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("product/category/minPrice")
	public ResponseEntity<?> getProductsCategoryMiniPrice(
			@RequestParam String category,
			@RequestParam Double miniPrice){
		
		try {
			List<Product> products = this.filterProduct.filterProductCategoryMinimumRange(category,miniPrice);
			return new ResponseEntity<>(products,HttpStatus.OK);
		}catch(Exception err) {
			System.err.println("Failed to get all products category by minimum price"+err.getMessage());
			String errorMessage = "Failed to get product categoryfilter by minimum price";
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("product/category/minPriceTomaxPrice")
	public ResponseEntity<?> getProductsCategoryMiniPriceToMaxPrice(
			@RequestParam String category,
			@RequestParam Double miniPrice,
			@RequestParam Double maxPrice){
		
		try {
			List<Product> products = this.filterProduct.filterProductCategoryMinRangeToMaxRange(category, miniPrice, maxPrice);
			return new ResponseEntity<>(products,HttpStatus.OK);
		}catch(Exception err) {
			System.err.println("Failed to get all products category by minimum price to maximum price"+err.getMessage());
			String errorMessage = "Failed to get product categoryfilter by minimum price to maximum price";
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("product/category/maxPrice-AscOrder")
	public ResponseEntity<?> getProductsCategoryMaxPriceAscOrder(@RequestParam String category){
		
		try {
			List<Product> products = this.filterProduct.filterProductCategoryBYAscOrderPrice(category);
			return new ResponseEntity<>(products,HttpStatus.OK);
		}catch(Exception err) {
			System.err.println("Failed to get all products category by maximum price in Ascending order"+err.getMessage());
			String errorMessage = "Failed to get product categoryfilter by maximum price in Ascending Order";
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("product/category/minPrice-DsceOrder")
	public ResponseEntity<?> getProductsCategoryMinPriceDescOrder(@RequestParam String category){
		
		try {
			List<Product> products = this.filterProduct.filterProductCategoryByDsceOrderPrice(category);
			return new ResponseEntity<>(products,HttpStatus.OK);
		}catch(Exception err) {
			System.err.println("Failed to get all products category by minimum price in Descending order"+err.getMessage());
			String errorMessage = "Failed to get product categoryfilter by minimum price in Descending Order";
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}