package com.levanxstore.persistence.repositoryimpl;

import com.levanxstore.domain.dto.InvestorDTO;
import com.levanxstore.domain.repository.InvestorRepository;
import com.levanxstore.persistence.crud.InvestorCrudRepository;
import com.levanxstore.persistence.entity.Investor;
import com.levanxstore.persistence.mapper.InvestorMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InvestorRepositoryImpl implements InvestorRepository {

    private final InvestorCrudRepository crudRepository;
    private final InvestorMapper mapper;

    public InvestorRepositoryImpl(InvestorCrudRepository crudRepository, InvestorMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public InvestorDTO save(InvestorDTO investorDTO) {
        Investor entity = mapper.toEntity(investorDTO);
        return mapper.toDto(crudRepository.save(entity));
    }

    @Override
    public Optional<InvestorDTO> findById(Long id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<InvestorDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<InvestorDTO> findByPhone(String phone) {
        return crudRepository.findByPhone(phone).map(mapper::toDto);
    }

    @Override
    public Optional<InvestorDTO> findByEmail(String email) {
        return crudRepository.findByEmail(email).map(mapper::toDto);
    }

    @Override
    public void deleteById(Long id) {
        crudRepository.deleteById(id);
    }
}
