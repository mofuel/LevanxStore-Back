package com.levanxstore.controller;

import com.levanxstore.domain.dto.CreateSaleRequestDTO;
import com.levanxstore.domain.dto.SaleDTO;
import com.levanxstore.domain.dto.SaleItemDTO;
import com.levanxstore.domain.dto.SaleResponseDTO;
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

    @PostMapping("/full")
    public ResponseEntity<SaleResponseDTO> createFull(@RequestBody CreateSaleRequestDTO request) {
        SaleResponseDTO result = saleService.createSale(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<SaleDTO> cancel(@PathVariable Long id) {
        SaleDTO cancelled = saleService.cancelSale(id);
        return ResponseEntity.ok(cancelled);
    }

    @PatchMapping("/{id}/items/{itemId}/return")
    public ResponseEntity<SaleItemDTO> returnItem(@PathVariable Long id, @PathVariable Long itemId) {
        SaleItemDTO returned = saleService.returnItem(id, itemId);
        return ResponseEntity.ok(returned);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        saleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
