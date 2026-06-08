package com.levanxstore.controller;

import com.levanxstore.domain.dto.ProductModelDTO;
import com.levanxstore.domain.service.ProductModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/product-models")
public class ProductModelController {

    private final ProductModelService productModelService;

    public ProductModelController(ProductModelService productModelService) {
        this.productModelService = productModelService;
    }

    @GetMapping
    public ResponseEntity<List<ProductModelDTO>> getAll() {
        return ResponseEntity.ok(productModelService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModelDTO> getById(@PathVariable Long id) {
        return productModelService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-brand/{brand}")
    public ResponseEntity<List<ProductModelDTO>> getByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(productModelService.findByBrand(brand));
    }

    @PostMapping
    public ResponseEntity<ProductModelDTO> create(@RequestBody ProductModelDTO dto) {
        ProductModelDTO saved = productModelService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productModelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
