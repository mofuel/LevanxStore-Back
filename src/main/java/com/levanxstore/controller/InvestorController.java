package com.levanxstore.controller;

import com.levanxstore.domain.dto.InvestorDTO;
import com.levanxstore.domain.service.InvestorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/investors")
public class InvestorController {

    private final InvestorService investorService;

    public InvestorController(InvestorService investorService) {
        this.investorService = investorService;
    }

    @GetMapping
    public ResponseEntity<List<InvestorDTO>> getAll() {
        return ResponseEntity.ok(investorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvestorDTO> getById(@PathVariable Long id) {
        return investorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InvestorDTO> create(@RequestBody InvestorDTO dto) {
        InvestorDTO saved = investorService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        investorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
