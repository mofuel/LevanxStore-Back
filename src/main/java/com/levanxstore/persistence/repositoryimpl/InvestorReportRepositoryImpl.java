package com.levanxstore.persistence.repositoryimpl;

import com.levanxstore.domain.dto.InvestorReportDTO;
import com.levanxstore.domain.repository.InvestorReportRepository;
import com.levanxstore.persistence.crud.InvestorReportCrudRepository;
import com.levanxstore.persistence.entity.Investor;
import com.levanxstore.persistence.entity.InvestorReport;
import com.levanxstore.persistence.mapper.InvestorReportMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InvestorReportRepositoryImpl implements InvestorReportRepository {

    private final InvestorReportCrudRepository crudRepository;
    private final InvestorReportMapper mapper;

    @PersistenceContext
    private EntityManager entityManager;

    public InvestorReportRepositoryImpl(InvestorReportCrudRepository crudRepository, InvestorReportMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public InvestorReportDTO save(InvestorReportDTO investorReportDTO) {
        InvestorReport entity = mapper.toEntity(investorReportDTO);
        if (investorReportDTO.getInvestorId() != null) {
            entity.setInvestor(entityManager.getReference(Investor.class, investorReportDTO.getInvestorId()));
        }
        return mapper.toDto(crudRepository.save(entity));
    }

    @Override
    public Optional<InvestorReportDTO> findById(Long id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<InvestorReportDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<InvestorReportDTO> findByInvestorId(Long investorId) {
        return crudRepository.findByInvestorId(investorId).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<InvestorReportDTO> findByPeriod(String period) {
        return crudRepository.findByPeriod(period).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        crudRepository.deleteById(id);
    }
}
