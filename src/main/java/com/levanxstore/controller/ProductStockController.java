package com.levanxstore.controller;

import com.levanxstore.domain.dto.ProductStockDTO;
import com.levanxstore.domain.service.ProductStockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/product-stock")
public class ProductStockController {

    private final ProductStockService productStockService;

    public ProductStockController(ProductStockService productStockService) {
        this.productStockService = productStockService;
    }

    @GetMapping
    public ResponseEntity<List<ProductStockDTO>> getAll() {
        return ResponseEntity.ok(productStockService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductStockDTO> getById(@PathVariable Long id) {
        return productStockService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-product/{productId}")
    public ResponseEntity<List<ProductStockDTO>> getByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(productStockService.findByProductId(productId));
    }

    @PostMapping
    public ResponseEntity<ProductStockDTO> create(@RequestBody ProductStockDTO dto) {
        ProductStockDTO saved = productStockService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productStockService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}