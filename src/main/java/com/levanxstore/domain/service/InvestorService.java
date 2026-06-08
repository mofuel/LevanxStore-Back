package com.levanxstore.domain.service;

import com.levanxstore.domain.dto.InvestorDTO;
import com.levanxstore.domain.repository.InvestorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InvestorService {

    private final InvestorRepository investorRepository;

    public InvestorService(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    public InvestorDTO save(InvestorDTO dto) {
        if (dto.getFirstName() == null || dto.getFirstName().isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (dto.getLastName() == null || dto.getLastName().isBlank()) {
            throw new IllegalArgumentException("El apellido es obligatorio");
        }
        dto.setFirstName(dto.getFirstName().trim());
        dto.setLastName(dto.getLastName().trim());
        if (dto.getPhone() != null) {
            dto.setPhone(dto.getPhone().trim());
            if (investorRepository.findByPhone(dto.getPhone()).isPresent()) {
                throw new IllegalArgumentException("Ya existe un inversor con ese teléfono");
            }
        }
        if (dto.getEmail() != null) {
            dto.setEmail(dto.getEmail().trim().toLowerCase());
            if (investorRepository.findByEmail(dto.getEmail()).isPresent()) {
                throw new IllegalArgumentException("Ya existe un inversor con ese email");
            }
        }
        return investorRepository.save(dto);
    }

    public Optional<InvestorDTO> findById(Long id) {
        return investorRepository.findById(id);
    }

    public List<InvestorDTO> findAll() {
        return investorRepository.findAll();
    }

    public void deleteById(Long id) {
        investorRepository.deleteById(id);
    }
}
