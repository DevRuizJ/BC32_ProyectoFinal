package com.BC32.SalesMS.Service.Implement;

import com.BC32.SalesMS.Model.Sales;
import com.BC32.SalesMS.Repository.ISalesRepository;
import com.BC32.SalesMS.Service.ISalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SalesImpl implements ISalesService {

    @Autowired
    private ISalesRepository repo;

    @Override
    public Mono<Sales> register(Sales obj) {
        return null;
    }

    @Override
    public Mono<Sales> modify(Sales obj, Integer id) {
        return null;
    }

    @Override
    public Flux<Sales> getAll() {
        return null;
    }

    @Override
    public Mono<Sales> getById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Mono<Sales> delete(Integer id) {
        return null;
    }

    @Override
    public Flux<Sales> getSalesListByidClient(Integer idClient) {

        return null;
    }
}
