package io.eddie.productsservice.controller;

import io.eddie.productsservice.dto.ProductRequest;
import io.eddie.productsservice.entity.Products;
import io.eddie.productsservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductApiController {

    private final ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Products> save(ProductRequest request) {
        return ResponseEntity.ok(service.save(request));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Products> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }


    @GetMapping
    public ResponseEntity<List<Products>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody ProductRequest request, @PathVariable Long id) {
        service.update(request, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
