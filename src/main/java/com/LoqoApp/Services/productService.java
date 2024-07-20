package com.LoqoApp.Services;

import java.util.List;
import com.LoqoApp.Models.Product;
import com.LoqoApp.Payload.apiResponse;

public interface productService {
	
	public Product createNewProduct(Product newProduct);
	public List<Product> getAllProducts() throws Exception;
	public Product getProductById(String productId);
	public Product updateProduct(Product newProduct, String productId);
	public apiResponse deleteProduct(String productId);
	
	

}
