package com.levanxstore.persistence.repositoryimpl;

import com.levanxstore.domain.dto.LoyaltyAccountDTO;
import com.levanxstore.domain.repository.LoyaltyAccountRepository;
import com.levanxstore.persistence.crud.LoyaltyAccountCrudRepository;
import com.levanxstore.persistence.entity.Customer;
import com.levanxstore.persistence.entity.LoyaltyAccount;
import com.levanxstore.persistence.mapper.LoyaltyAccountMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class LoyaltyAccountRepositoryImpl implements LoyaltyAccountRepository {

    private final LoyaltyAccountCrudRepository crudRepository;
    private final LoyaltyAccountMapper mapper;

    @PersistenceContext
    private EntityManager entityManager;

    public LoyaltyAccountRepositoryImpl(LoyaltyAccountCrudRepository crudRepository, LoyaltyAccountMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public LoyaltyAccountDTO save(LoyaltyAccountDTO loyaltyAccountDTO) {
        LoyaltyAccount entity = mapper.toEntity(loyaltyAccountDTO);
        if (loyaltyAccountDTO.getCustomerId() != null) {
            entity.setCustomer(entityManager.getReference(Customer.class, loyaltyAccountDTO.getCustomerId()));
        }
        return mapper.toDto(crudRepository.save(entity));
    }

    @Override
    public Optional<LoyaltyAccountDTO> findById(Long id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<LoyaltyAccountDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<LoyaltyAccountDTO> findByCustomerId(Long customerId) {
        return crudRepository.findByCustomerId(customerId).map(mapper::toDto);
    }

    @Override
    public Optional<LoyaltyAccountDTO> findByToken(String token) {
        return crudRepository.findByToken(token).map(mapper::toDto);
    }

    @Override
    public void deleteById(Long id) {
        crudRepository.deleteById(id);
    }
}
