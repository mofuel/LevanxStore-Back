package com.levanxstore.domain.service;

import com.levanxstore.domain.dto.InvestorReportDTO;
import com.levanxstore.domain.repository.InvestorReportRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InvestorReportService {

    private final InvestorReportRepository investorReportRepository;

    public InvestorReportService(InvestorReportRepository investorReportRepository) {
        this.investorReportRepository = investorReportRepository;
    }

    public InvestorReportDTO save(InvestorReportDTO dto) {
        if (dto.getInvestorId() == null) {
            throw new IllegalArgumentException("El inversor es obligatorio");
        }
        if (dto.getPeriod() == null || dto.getPeriod().isBlank()) {
            throw new IllegalArgumentException("El período es obligatorio");
        }
        return investorReportRepository.save(dto);
    }

    public Optional<InvestorReportDTO> findById(Long id) {
        return investorReportRepository.findById(id);
    }

    public List<InvestorReportDTO> findAll() {
        return investorReportRepository.findAll();
    }

    public List<InvestorReportDTO> findByInvestorId(Long investorId) {
        return investorReportRepository.findByInvestorId(investorId);
    }

    public void deleteById(Long id) {
        investorReportRepository.deleteById(id);
    }
}