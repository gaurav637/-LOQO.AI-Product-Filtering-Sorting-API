package com.LoqoApp.Services.Implementation;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LoqoApp.Exception.ProductNotFoundException;
import com.LoqoApp.Models.Product;
import com.LoqoApp.Payload.apiResponse;
import com.LoqoApp.Repository.productRepository;
import com.LoqoApp.Services.productService;

@Service
public class productServiceImplementation implements productService {
	
	@Autowired
	private productRepository productRepo;

	@Override
	public Product createNewProduct(Product newProduct) {
	    try {
	        // Set createdAt to the current date if it is not already set
	        if (newProduct.getCreatedAt() == null) {
	            newProduct.setCreatedAt(new Date());
	        }
	        Product savedProduct = productRepo.save(newProduct);// Save the new product 
	        return savedProduct;
	    } catch (Exception e) {
	        System.err.println("Failed to create a new product: " + e.getMessage());
	        throw e; 
	    }
	}

	
	@Override
	public List<Product> getAllProducts() throws Exception {
		try {
			List<Product> allProducts = productRepo.findAll(); // find all products into database 
			if(allProducts==null) { // if products is null then return error message and exception
				System.err.println("Product modul is Empty!");
				throw new Exception("Products Empty!");
			}
			return allProducts;
			
		}catch(Exception err) {
			System.err.println("Failed to get all products data!" + err.getMessage());
			throw err;
		}
		
	}
	

	@Override
	public Product getProductById(String productId) {
		Product product = productRepo.findById(productId)
				                     .orElseThrow(() -> // if product not found then return error (product not found)
				                     new ProductNotFoundException("Product","productId",productId));
		return product;
	}

	@Override
	public Product updateProduct(Product newProduct, String productId) {
		try {
			Product product = productRepo.findById(productId)
	                .orElseThrow(() -> // if product not found then return error (product not found with productId)
	                new ProductNotFoundException("Product","productId",productId));
			
			
			// check which which properties change or update 
			if(newProduct.getInStock() == true && product.getInStock()==false
					|| newProduct.getInStock() == false && product.getInStock()==true) {
				product.setInStock(newProduct.getInStock());
			}
			if(newProduct.getCategory()!=null) {
				product.setCategory(newProduct.getCategory());
			}
			if(newProduct.getCreatedAt()!=null) {
				product.setCreatedAt(newProduct.getCreatedAt());
			}
			if(newProduct.getName()!=null) {
				product.setName(newProduct.getName());
			}
			if(newProduct.getPrice()!=product.getPrice()) {
				product.setPrice(newProduct.getPrice());
			}
			if(newProduct.getRating()!=product.getRating()) {
				product.setRating(newProduct.getRating());
			}
			
			Product updatedProduct = productRepo.save(product);
			return updatedProduct;
			
		}catch(Exception err) {
			System.err.println("failed to update product"+err.getMessage());
			throw err;
		}
	}

	@Override
	public apiResponse deleteProduct(String productId) {
		try {
			Product product = productRepo.findById(productId)
	                .orElseThrow(() -> // if product not found then return error (product not found with productId)
	                new ProductNotFoundException("Product","productId",productId));
			productRepo.delete(product);
			apiResponse response =  new apiResponse("Product deleted Succssfully","true");
			return response;
			
		}catch(Exception err) {
			System.err.println("failed to delete product"+err.getMessage());
			throw err;
		}
	}
	
	

	
	

}
