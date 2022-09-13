package com.BC32.ClientMS.Service.Implement;

import com.BC32.ClientMS.Model.Client;
import com.BC32.ClientMS.Repository.IClientRepository;
import com.BC32.ClientMS.Service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class ClientImpl implements IClientService {

    @Autowired
    private IClientRepository repo;

    @Override
    public Mono<Client> register(Client obj) {
        return repo.save(obj);
    }

    @Override
    public Mono<Client> modify(Client obj, Integer idClient) {

        return repo.findById(idClient)
                .doOnNext(e -> e.setIdClient(idClient))
                .flatMap(updateClient -> repo.save(obj).then(Mono.just(obj)));
    }

    @Override
    public Flux<Client> getAll() {
        return repo.findAll().switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<Client> getById(Integer idClient) {
        return repo.findById(idClient);
    }

    @Override
    public Mono<Client> delete(Integer idClient) {

        return getById(idClient)
                .switchIfEmpty(Mono.empty())
                .filter(Objects::nonNull)
                .flatMap(c -> repo.delete(c).then(Mono.just(c)));
    }
}
