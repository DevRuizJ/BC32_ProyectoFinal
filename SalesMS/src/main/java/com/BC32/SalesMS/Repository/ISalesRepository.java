package com.BC32.SalesMS.Repository;

import com.BC32.SalesMS.Model.Sales;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalesRepository extends ReactiveMongoRepository<Sales, Integer> {
}
