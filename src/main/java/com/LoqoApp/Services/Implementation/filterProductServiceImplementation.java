package com.LoqoApp.Services.Implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LoqoApp.Models.Product;
import com.LoqoApp.Repository.productRepository;
import com.LoqoApp.Services.filterProductService;


@Service
public class filterProductServiceImplementation implements filterProductService{
	
	@Autowired
	private productRepository productRepo;

	@Override
	public List<Product> filterByCategory(String category) {
		try {
			List<Product> product = productRepo.findByCategory(category);
			return product;	
		}catch(Exception err) {
			System.err.println("Failed to get product filter by category"+err.getMessage());
			throw err;
		}
	}

	@Override
	public List<Product> filterByMaxPrice(Double maxPrice) {
		try {
			List<Product> products = productRepo.findByPriceGreaterThanEqual(maxPrice);
			return products;
			
		}catch(Exception err) {
			System.err.println("Failed to get product based on their max price!" +err.getMessage());
			throw err;
		}
	}

	@Override
	public List<Product> filterByMiniPrice(Double minPrice) {
		try {
			List<Product> products = productRepo.findByPriceLessThanEqual(minPrice);
			return products;
			
		}catch(Exception err) {
			System.err.println("Failed to find all products "+err.getMessage());
			throw err;
		}
	}

	@Override
	public List<Product> filterByInStock(Boolean value) {
		try {
			List<Product> products = productRepo.findByInStock(value);
			return products;
			
		}catch(Exception err) {
			System.err.println("Failed to get products filter by in stock!"+err.getMessage());
			throw err;
		}
	}

	@Override
	public List<Product> filterByProductCategoryInStock(String category, Boolean value) {
		try {
			List<Product> products = productRepo.findByCategoryAndInStock(category, value);
			return products;
		}catch(Exception err) {
			System.err.println("Failed to get product filter by inStock with category!"+err.getMessage());
			throw err;
		}
	}

	@Override
	public Product filterMaximumPriceProduct() {
		try {
			Product product = productRepo.findTopByOrderByPriceAsc();
			return product;
			
		}catch(Exception err) {
			System.err.println("Failed to get products by more expensive compare to other products!"+err.getMessage());
			throw err;
		}
	}

	@Override
	public Product filterMinimumPriceProduct() {
		try {
			Product product = productRepo.findTopByOrderByPriceDesc();
			return product;
			
		}catch(Exception err) {
			System.err.println("Failed to get products by less cheaper compare to other products!"+err.getMessage());
			throw err;
		}
	}

	@Override
	public List<Product> filterMinRangeToMaxRangeProduct(Double minPrice, Double maxPrice) {
		try {
			List<Product> products = productRepo.findByPriceBetween(minPrice, maxPrice);
			return products;
			
		}catch(Exception err) {
			System.err.println("Failed to get products based on all products between min price and max price"+err.getMessage());
			throw err;
		}
	}

	@Override
	public List<Product> filterProductCategoryMaximumRange(String category, Double maxPrice) {
		try {
			List<Product> product = productRepo.findByCategoryAndPriceGreaterThanEqual(category, maxPrice);
			return product;
			
		}catch(Exception err) {
			System.out.println("Failed to get products based on category and maximum price"+err.getMessage());
			throw err;
		}
	}

	@Override
	public List<Product> filterProductCategoryMinimumRange(String category, Double minPrice) {
		try {
			List<Product> product = productRepo.findByCategoryAndPriceLessThanEqual(category, minPrice);
			return product;
			
		}catch(Exception err) {
			System.out.println("Failed to get product based on their category and minimum price "+err.getMessage());
			throw err;
		}
	}

	@Override
	public List<Product> filterProductCategoryMinRangeToMaxRange(String category, Double minPrice, Double maxprice) {
		try {
			List<Product> product = productRepo.findByCategoryAndPriceBetween(category, minPrice, maxprice);
			return product;
			
		}catch(Exception err) {
			System.err.println("Failed to find products based on their category and price between minimum price and max price!"+err.getMessage());
			throw err;
		}
	}

	@Override
	public List<Product> filterProductCategoryBYAscOrderPrice(String category) {
		try {
			List<Product> product = productRepo.findByCategoryOrderByPriceAsc(category);
			return product;
			
		}catch(Exception err) {
			System.err.println("Failed to get prodcuts based on their category and price ascending order!"+err.getMessage());
			throw err;
		}
	}

	@Override
	public List<Product> filterProductCategoryByDsceOrderPrice(String category) {
		try {
			List<Product> product = productRepo.findByCategoryOrderByPriceDesc(category);
			return product;
			
		}catch(Exception err) {
			System.err.println("Failed to get prodcuts based on their category and price descending order!"+err.getMessage());
			throw err;
		}
	}

}
