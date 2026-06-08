package com.levanxstore.controller;

import com.levanxstore.domain.dto.LoyaltyAccountDTO;
import com.levanxstore.domain.service.LoyaltyAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/loyalty-accounts")
public class LoyaltyAccountController {

    private final LoyaltyAccountService loyaltyAccountService;

    public LoyaltyAccountController(LoyaltyAccountService loyaltyAccountService) {
        this.loyaltyAccountService = loyaltyAccountService;
    }

    @GetMapping
    public ResponseEntity<List<LoyaltyAccountDTO>> getAll() {
        return ResponseEntity.ok(loyaltyAccountService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoyaltyAccountDTO> getById(@PathVariable Long id) {
        return loyaltyAccountService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-customer/{customerId}")
    public ResponseEntity<LoyaltyAccountDTO> getByCustomer(@PathVariable Long customerId) {
        return loyaltyAccountService.findByCustomerId(customerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LoyaltyAccountDTO> create(@RequestBody LoyaltyAccountDTO dto) {
        LoyaltyAccountDTO saved = loyaltyAccountService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        loyaltyAccountService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
