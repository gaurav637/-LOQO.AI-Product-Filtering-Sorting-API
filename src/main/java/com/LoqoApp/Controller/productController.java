package com.LoqoApp.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.LoqoApp.Models.Product;
import com.LoqoApp.Payload.apiResponse;
import com.LoqoApp.Services.productService;

@RestController
@RequestMapping("product-api")
public class productController {
	
	@Autowired
	private productService product;
	
	// create new product 
	
	@PostMapping("/create/new") 
	public ResponseEntity<?> createNewProduct(@RequestBody Product newProduct ){
		try {
			Product createdProduct = this.product.createNewProduct(newProduct);
			return new ResponseEntity<>(createdProduct , HttpStatus.CREATED); //return the product details  and server code 201
			
		}catch(Exception err) {
			String errorMessage = "Failed to create new Product"+err.getMessage();
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR); // return error message and 500 internal server error
		}
	}
	
	//get all products 
	
	@GetMapping("/get/all-products")
	public ResponseEntity<?> getAllProducts(){
		try {
			List<Product> allProducts = this.product.getAllProducts();
			return new ResponseEntity<>(allProducts,HttpStatus.OK);
			
		}catch(Exception err) {
			String errorMessage = "Failed to get all product data !"+err.getMessage();
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//get products by id
	
	@GetMapping("/get/product-by-id/{productId}")
	public ResponseEntity<?> getProductById(@PathVariable("productId") String productId){
		try {
			 Product product = this.product.getProductById(productId);
			 return new ResponseEntity<>(product,HttpStatus.OK);
		}catch(Exception error) {
			String errorMessage = "Failed to get product by productId!";
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// update the products properties 
	
	@PutMapping("/update/product/{productId}")
	public ResponseEntity<?> updateProducts(
			@RequestBody Product newProduct , 
			@PathVariable("productId") String productId){
		try {
			Product updatedProduct = this.product.updateProduct(newProduct, productId);
			return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
		}catch(Exception error) {
			String errorMessage = "Failed to update products!"+error.getMessage();
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// delete the products
	
	@DeleteMapping("/delete/product/{productId}")
	public ResponseEntity<apiResponse> deleteProducts(@PathVariable("productId") String productId){
		try {
			apiResponse response = this.product.deleteProduct(productId);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}catch(Exception error) {
			apiResponse errorMessage = new apiResponse(error.getMessage(),"false");
			return new ResponseEntity<>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
