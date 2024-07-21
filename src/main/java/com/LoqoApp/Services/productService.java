package com.LoqoApp.Services;

import java.util.List;
import com.LoqoApp.Models.Product;
import com.LoqoApp.Payload.apiResponse;

public interface productService { // Basic CRUD operation
	
	public Product createNewProduct(Product newProduct); // create new products
	public List<Product> getAllProducts() throws Exception; // find all products
	public Product getProductById(String productId); // find products by id
	public Product updateProduct(Product newProduct, String productId); // update products 
	public apiResponse deleteProduct(String productId); // delete products 
}
