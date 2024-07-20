package com.LoqoApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.LoqoApp.Models.Product;

public interface productRepository extends MongoRepository<Product , String> {

}
