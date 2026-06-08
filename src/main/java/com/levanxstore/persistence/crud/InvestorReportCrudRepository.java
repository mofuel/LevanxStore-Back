package com.levanxstore.persistence.crud;

import com.levanxstore.persistence.entity.InvestorReport;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InvestorReportCrudRepository extends JpaRepository<InvestorReport, Long> {

    List<InvestorReport> findByInvestorId(Long investorId);

    List<InvestorReport> findByPeriod(String period);

}
