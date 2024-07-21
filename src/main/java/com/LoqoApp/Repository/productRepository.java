package com.LoqoApp.Repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.LoqoApp.Models.Product;

public interface productRepository extends MongoRepository<Product , String> {
	
	// Filter Products
	
	List<Product> findByCategory(String category);
	
	List<Product> findByPriceGreaterThanEqual(Double price);
	
	List<Product> findByPriceLessThanEqual(Double price);
	
	List<Product> findByInStock(Boolean value);
	
	List<Product> findByCategoryAndInStock(String category,Boolean InStock);
	
	@Aggregation(pipeline = {
		    "{ '$sort': { 'price': 1 } }",
		    "{ '$limit': 1 }"
	})
	
    Product findTopByOrderByPriceDesc();
	@Aggregation(pipeline = {
		    "{ '$sort': { 'price': -1 } }",
		    "{ '$limit': 1 }"
	})
	
    Product findTopByOrderByPriceAsc();
	
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
    
    List<Product> findByCategoryAndPriceGreaterThanEqual(String category, Double maxPrice);
    
    List<Product> findByCategoryAndPriceLessThanEqual(String category, Double minPrice);
    
    List<Product> findByCategoryAndPriceBetween(String category, Double minPrice, Double maxPrice);
    
    List<Product> findByCategoryOrderByPriceAsc(String category);
    
    List<Product> findByCategoryOrderByPriceDesc(String category);
    List<Product> findByCategoryAndPriceBetweenAndInStock(
            String category,
            Double minPrice,
            Double maxPrice,
            Boolean inStock,
            Sort sort);
    
    // Sorting Products
    
    
    List<Product> findAllByOrderByPriceAsc();
    
    List<Product> findAllByOrderByPriceDesc();

    List<Product> findAllByOrderByRatingAsc();
    
    List<Product> findAllByOrderByRatingDesc();
    
    List<Product> findAllByOrderByCreatedAtAsc();
    
    List<Product> findAllByOrderByCreatedAtDesc();
    
}

