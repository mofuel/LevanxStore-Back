package com.levanxstore.persistence.repositoryimpl;

import com.levanxstore.domain.dto.MarketingPartnerDTO;
import com.levanxstore.domain.repository.MarketingPartnerRepository;
import com.levanxstore.persistence.crud.MarketingPartnerCrudRepository;
import com.levanxstore.persistence.entity.MarketingPartner;
import com.levanxstore.persistence.mapper.MarketingPartnerMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MarketingPartnerRepositoryImpl implements MarketingPartnerRepository {

    private final MarketingPartnerCrudRepository crudRepository;
    private final MarketingPartnerMapper mapper;

    public MarketingPartnerRepositoryImpl(MarketingPartnerCrudRepository crudRepository, MarketingPartnerMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public MarketingPartnerDTO save(MarketingPartnerDTO marketingPartnerDTO) {
        MarketingPartner entity = mapper.toEntity(marketingPartnerDTO);
        return mapper.toDto(crudRepository.save(entity));
    }

    @Override
    public Optional<MarketingPartnerDTO> findById(Long id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<MarketingPartnerDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        crudRepository.deleteById(id);
    }
}
