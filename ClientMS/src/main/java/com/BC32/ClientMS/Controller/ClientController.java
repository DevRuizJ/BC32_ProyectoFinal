package com.BC32.ClientMS.Controller;

import com.BC32.ClientMS.Model.Client;
import com.BC32.ClientMS.Service.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client")
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private IClientService serv;

    @GetMapping("/list")
    public ResponseEntity<Flux<Client>> getClientList(){

        Flux<Client> result = null;

        try
        {
            result = serv.getAll();
        }
        catch (Exception ex) {
            return new ResponseEntity<Flux<Client>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        finally {
            logger.info("getClientList - Fin de controller");
        }

        return new ResponseEntity<Flux<Client>>(result, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Mono<Client>> createClient(@RequestBody Client client){

        Mono<Client> result = null;

        try{
            result = serv.register(client);
        }
        catch (Exception ex){

        }
        finally {
            logger.info("createClient - Fin de controller");
        }

        return new ResponseEntity<Mono<Client>>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{idClient}")
    public ResponseEntity<Mono<Client>> getClientById(@PathVariable("idClient") Integer idClient){

        Mono<Client> result = null;

        try{
            result = serv.getById(idClient);
        }
        catch (Exception ex){

        }
        finally {
            logger.info("getClientById - Fin de controller");
        }

        return new ResponseEntity<Mono<Client>>(result, HttpStatus.OK);
    }

    @PutMapping("/update/{idClient}")
    public ResponseEntity<Mono<Client>> updateClient(@RequestBody Client client, @PathVariable("idClient") Integer idClient){

        Mono<Client> result = null;

        try{
            result = serv.modify(client, idClient);
        }
        catch (Exception ex){

        }
        finally {
            logger.info("updateClient - Fin de controller");
        }

         return new ResponseEntity<Mono<Client>>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idClient}")
    public ResponseEntity<Mono<Client>> deleteClient(@PathVariable("idClient") Integer idClient){

        Mono<Client> result = null;

        try {
            result = serv.delete(idClient);
        }
        catch (Exception ex){

        }
        finally {
            logger.info("deleteClient - Fin de controller");
        }

        return new ResponseEntity<Mono<Client>>(result, HttpStatus.OK);
    }
}
