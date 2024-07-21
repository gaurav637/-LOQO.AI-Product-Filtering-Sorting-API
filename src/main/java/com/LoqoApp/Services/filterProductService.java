package com.LoqoApp.Services;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.LoqoApp.Models.Product;

public interface filterProductService {
	
	public List<Product> filterByCategory(String category); //filter product by category
	public List<Product> filterByMaxPrice(Double maxPrice); // filter all product by maximum price
	public List<Product> filterByMiniPrice(Double minPrice); // filter all product by minimum price
	public List<Product> filterByInStock(Boolean value); // filter all products  based on their stock availability
	public List<Product> filterByProductCategoryInStock(String category,Boolean value); // filter products by based on their category and stack availability
	public Product filterMaximumPriceProduct(); // filter expensive product compare to other all category products 
	public Product filterMinimumPriceProduct(); // // filter cheapest product compare to other all category products 
	public List<Product> filterMinRangeToMaxRangeProduct(Double minPrice,Double maxPrice); // filter all products between minimum price and maximum price
	public List<Product> filterProductCategoryMaximumRange(String category,Double maxPrice); // filter all product category which price same and more than max price
	public List<Product> filterProductCategoryMinimumRange(String category, Double minPrice); // filter all products category which price same and less than minimum price
	public List<Product> filterProductCategoryMinRangeToMaxRange(String category,Double minPrice,Double maxprice); // filter all products which price between minimum and maximum
	public List<Product> filterProductCategoryBYAscOrderPrice(String category); // filter all product category their Ascending order price 
	public List<Product> filterProductCategoryByDsceOrderPrice(String category); // filter all product category their Descending order price
	public List<Product> getFilteredProducts(
            String category,
            Double minPrice,
            Double maxPrice,
            Boolean inStock,
            Sort sort);

}
