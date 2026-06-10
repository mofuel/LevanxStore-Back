package com.levanxstore.persistence.mapper;

import com.levanxstore.domain.dto.InvestorReportDTO;
import com.levanxstore.persistence.entity.InvestorReport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InvestorReportMapper {

    @Mapping(target = "investorId", expression = "java(investorReport.getInvestor() != null ? investorReport.getInvestor().getId() : null)")
    @Mapping(target = "investorName", expression = "java(investorReport.getInvestor() != null ? investorReport.getInvestor().getFirstName() + \" \" + investorReport.getInvestor().getLastName() : null)")
    InvestorReportDTO toDto(InvestorReport investorReport);

    @Mapping(target = "investor", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    InvestorReport toEntity(InvestorReportDTO investorReportDTO);
}
