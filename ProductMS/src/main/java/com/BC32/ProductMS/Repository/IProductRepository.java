package com.BC32.ProductMS.Repository;

import com.BC32.ProductMS.Model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IProductRepository extends ReactiveMongoRepository<Product, Integer> {
}
