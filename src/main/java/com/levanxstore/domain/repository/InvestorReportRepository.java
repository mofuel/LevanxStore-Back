package com.levanxstore.domain.repository;

import com.levanxstore.domain.dto.InvestorReportDTO;
import java.util.List;
import java.util.Optional;

public interface InvestorReportRepository {

    InvestorReportDTO save(InvestorReportDTO investorReportDTO);

    Optional<InvestorReportDTO> findById(Long id);

    List<InvestorReportDTO> findAll();

    List<InvestorReportDTO> findByInvestorId(Long investorId);

    List<InvestorReportDTO> findByPeriod(String period);

    void deleteById(Long id);

}
