package com.levanxstore.controller;

import com.levanxstore.domain.dto.SaleDTO;
import com.levanxstore.domain.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAll() {
        return ResponseEntity.ok(saleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO> getById(@PathVariable Long id) {
        return saleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-customer/{customerId}")
    public ResponseEntity<List<SaleDTO>> getByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(saleService.findByCustomerId(customerId));
    }

    @PostMapping
    public ResponseEntity<SaleDTO> create(@RequestBody SaleDTO dto) {
        SaleDTO saved = saleService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        saleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
