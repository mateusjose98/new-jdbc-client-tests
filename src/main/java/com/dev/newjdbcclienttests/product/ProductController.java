package com.dev.newjdbcclienttests.product;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    final ProductRepository repository;


    @PostMapping
    public int addNewProduct(@RequestBody Product product) {
        return repository.save(product);
    }
    @GetMapping
    public List<Product> getAll() {
        return repository.read();
    }

    @GetMapping("{id}")
    public Optional<Product> getById(@PathVariable Integer id){
        return repository.readById(id);
    }

    @PutMapping("{id}")
    public int updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return repository.update(id, product);

    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id){
        repository.delete(id);
    }
}
