package com.LoqoApp.Repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.LoqoApp.Models.Product;

public interface productRepository extends MongoRepository<Product , String> {
	
	// Filter Products
	
	List<Product> findByCategory(String category); // get all products based on their category 
	
	List<Product> findByPriceGreaterThanEqual(Double price); // get all products based on their price equals and grater than 
	
	List<Product> findByPriceLessThanEqual(Double price); // get all products based on their price equals and less than 
	
	List<Product> findByInStock(Boolean value); // get all products based on their stock availability
	
	List<Product> findByCategoryAndInStock(String category,Boolean InStock); // get all products category based on their stock availability
	
	@Aggregation(pipeline = {
		    "{ '$sort': { 'price': 1 } }",
		    "{ '$limit': 1 }"
	})
    Product findTopByOrderByPriceDesc();//  find cheapest products in all products 
	
	@Aggregation(pipeline = {
		    "{ '$sort': { 'price': -1 } }",
		    "{ '$limit': 1 }"
	})
    Product findTopByOrderByPriceAsc(); //  find expensive product in all products 
	
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);// find all products their price between minimum price and maximum price
    
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
    
    
    List<Product> findAllByOrderByPriceAsc(); // get all products whose price sort Ascending order
    
    List<Product> findAllByOrderByPriceDesc(); // get all products whose price sort Descending order

    List<Product> findAllByOrderByRatingAsc(); // get all products whose rating sort Ascending order
    
    List<Product> findAllByOrderByRatingDesc(); // get all products whose rating sort Descending order
    
    List<Product> findAllByOrderByCreatedAtAsc(); // get all products whose createdAt sort Ascending order
    
    List<Product> findAllByOrderByCreatedAtDesc(); //  get all products whose createdAt sort Descending order
    
}

