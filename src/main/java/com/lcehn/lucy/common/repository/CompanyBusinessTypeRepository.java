package com.lcehn.lucy.common.repository;

import com.lcehn.lucy.common.model.BusinessType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyBusinessTypeRepository extends JpaRepository<BusinessType, Integer> {

}
