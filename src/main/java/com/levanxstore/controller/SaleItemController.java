package com.levanxstore.controller;

import com.levanxstore.domain.dto.SaleItemDTO;
import com.levanxstore.domain.service.SaleItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sale-items")
public class SaleItemController {

    private final SaleItemService saleItemService;

    public SaleItemController(SaleItemService saleItemService) {
        this.saleItemService = saleItemService;
    }

    @GetMapping
    public ResponseEntity<List<SaleItemDTO>> getAll() {
        return ResponseEntity.ok(saleItemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleItemDTO> getById(@PathVariable Long id) {
        return saleItemService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-sale/{saleId}")
    public ResponseEntity<List<SaleItemDTO>> getBySale(@PathVariable Long saleId) {
        return ResponseEntity.ok(saleItemService.findBySaleId(saleId));
    }

    @PostMapping
    public ResponseEntity<SaleItemDTO> create(@RequestBody SaleItemDTO dto) {
        SaleItemDTO saved = saleItemService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        saleItemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
