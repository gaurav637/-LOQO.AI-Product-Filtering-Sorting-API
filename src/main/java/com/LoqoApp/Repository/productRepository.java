package com.LoqoApp.Repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.LoqoApp.Models.Product;

public interface productRepository extends MongoRepository<Product , String> {
	
	List<Product> findByCategory(String category);
	List<Product> findByPriceGreaterThanEqual(Double price);
	List<Product> findByPriceLessThanEqual(Double price);
	List<Product> findByInStock(Boolean value);
	List<Product> findByCategoryAndInStock(String category,Boolean InStock);
	@Query(value = "{}", sort = "{ 'price' : -1 }")
    Product findTopByOrderByPriceDesc();
    @Query(value = "{}", sort = "{ 'price' : 1 }")
    Product findTopByOrderByPriceAsc();
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
    List<Product> findByCategoryAndPriceGreaterThanEqual(String category, Double maxPrice);
    List<Product> findByCategoryAndPriceLessThanEqual(String category, Double minPrice);
    List<Product> findByCategoryAndPriceBetween(String category, Double minPrice, Double maxPrice);
    List<Product> findByCategoryOrderByPriceAsc(String category);
    List<Product> findByCategoryOrderByPriceDesc(String category);
    @Query("{ 'category': ?0, 'price': { $gte: ?1, $lte: ?2 }, 'inStock': ?3 }")
    List<Product> filterProductCategoryMinPriceMaxPriceStockSortOrder(String category, Double minPrice, Double maxPrice, Boolean inStock, org.springframework.data.domain.Sort sort);
	
}

