package com.levanxstore.persistence.crud;

import com.levanxstore.persistence.entity.MarketingPartner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketingPartnerCrudRepository extends JpaRepository<MarketingPartner, Long> {
}
