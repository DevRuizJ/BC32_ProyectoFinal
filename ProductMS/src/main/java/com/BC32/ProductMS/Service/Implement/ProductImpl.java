package com.BC32.ProductMS.Service.Implement;

import com.BC32.ProductMS.Model.Product;
import com.BC32.ProductMS.Repository.IProductRepository;
import com.BC32.ProductMS.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class ProductImpl implements IProductService {

    @Autowired
    private IProductRepository repo;

    @Override
    public Mono<Product> register(Product obj) {
        return repo.save(obj);
    }

    @Override
    public Mono<Product> modify(Product obj, Integer idProduct) {
        return repo.findById(idProduct)
                .doOnNext(e -> e.setIdProduct(idProduct))
                .flatMap(updateClient -> repo.save(obj).then(Mono.just(obj)));
    }

    @Override
    public Flux<Product> getAll() {
        return repo.findAll().switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<Product> getById(Integer idProduct) {
        return repo.findById(idProduct);
    }

    @Override
    public Mono<Product> delete(Integer idProduct) {
        return getById(idProduct)
                .switchIfEmpty(Mono.empty())
                .filter(Objects::nonNull)
                .flatMap(c -> repo.delete(c).then(Mono.just(c)));
    }
}
