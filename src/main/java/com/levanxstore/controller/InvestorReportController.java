package com.levanxstore.controller;

import com.levanxstore.domain.dto.InvestorReportDTO;
import com.levanxstore.domain.service.InvestorReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/investor-reports")
public class InvestorReportController {

    private final InvestorReportService investorReportService;

    public InvestorReportController(InvestorReportService investorReportService) {
        this.investorReportService = investorReportService;
    }

    @GetMapping
    public ResponseEntity<List<InvestorReportDTO>> getAll() {
        return ResponseEntity.ok(investorReportService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvestorReportDTO> getById(@PathVariable Long id) {
        return investorReportService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-investor/{investorId}")
    public ResponseEntity<List<InvestorReportDTO>> getByInvestor(@PathVariable Long investorId) {
        return ResponseEntity.ok(investorReportService.findByInvestorId(investorId));
    }

    @PostMapping
    public ResponseEntity<InvestorReportDTO> create(@RequestBody InvestorReportDTO dto) {
        InvestorReportDTO saved = investorReportService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        investorReportService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
