package com.BC32.ClientMS.Repository;

import com.BC32.ClientMS.Model.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends ReactiveMongoRepository<Client, Integer> {
}
