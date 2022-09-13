package com.BC32.ProductMS.Controller;

import com.BC32.ProductMS.Model.Product;
import com.BC32.ProductMS.Service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private IProductService serv;

    @GetMapping("/list")
    public ResponseEntity<Flux<Product>> getProductList(){

        Flux<Product> result = null;

        try
        {
            result = serv.getAll();
        }
        catch (Exception ex) {
            return new ResponseEntity<Flux<Product>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        finally {
            logger.info("getProductList - Fin de controller");
        }

        return new ResponseEntity<Flux<Product>>(result, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Mono<Product>> createProduct(@RequestBody Product product){

        Mono<Product> result = null;

        try{
            result = serv.register(product);
        }
        catch (Exception ex){

        }
        finally {
            logger.info("createProduct - Fin de controller");
        }

        return new ResponseEntity<Mono<Product>>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<Mono<Product>> getProductById(@PathVariable("idProduct") Integer idProduct){

        Mono<Product> result = null;

        try{
            result = serv.getById(idProduct);
        }
        catch (Exception ex){

        }
        finally {
            logger.info("getProductById - Fin de controller");
        }

        return new ResponseEntity<Mono<Product>>(result, HttpStatus.OK);
    }

    @PutMapping("/update/{idProduct}")
    public ResponseEntity<Mono<Product>> updateProduct(@RequestBody Product product, @PathVariable("idProduct") Integer idProduct){

        Mono<Product> result = null;

        try{
            result = serv.modify(product, idProduct);
        }
        catch (Exception ex){

        }
        finally {
            logger.info("updateProduct - Fin de controller");
        }

        return new ResponseEntity<Mono<Product>>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idProduct}")
    public ResponseEntity<Mono<Product>> deleteProduct(@PathVariable("idProduct") Integer idProduct){

        Mono<Product> result = null;

        try {
            result = serv.delete(idProduct);
        }
        catch (Exception ex){

        }
        finally {
            logger.info("deleteProduct - Fin de controller");
        }

        return new ResponseEntity<Mono<Product>>(result, HttpStatus.OK);
    }
}
