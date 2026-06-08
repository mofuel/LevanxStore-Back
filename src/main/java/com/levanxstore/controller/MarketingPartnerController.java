package com.levanxstore.controller;

import com.levanxstore.domain.dto.MarketingPartnerDTO;
import com.levanxstore.domain.service.MarketingPartnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/marketing-partners")
public class MarketingPartnerController {

    private final MarketingPartnerService marketingPartnerService;

    public MarketingPartnerController(MarketingPartnerService marketingPartnerService) {
        this.marketingPartnerService = marketingPartnerService;
    }

    @GetMapping
    public ResponseEntity<List<MarketingPartnerDTO>> getAll() {
        return ResponseEntity.ok(marketingPartnerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarketingPartnerDTO> getById(@PathVariable Long id) {
        return marketingPartnerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MarketingPartnerDTO> create(@RequestBody MarketingPartnerDTO dto) {
        MarketingPartnerDTO saved = marketingPartnerService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        marketingPartnerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
