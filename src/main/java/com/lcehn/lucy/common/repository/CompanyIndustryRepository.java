package com.lcehn.lucy.common.repository;

import com.lcehn.lucy.common.model.Industry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyIndustryRepository extends JpaRepository<Industry, Integer> {
}
