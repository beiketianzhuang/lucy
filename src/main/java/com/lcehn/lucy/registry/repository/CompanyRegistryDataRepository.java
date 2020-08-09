package com.lcehn.lucy.registry.repository;

import com.lcehn.lucy.registry.model.CompanyData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRegistryDataRepository extends JpaRepository<CompanyData, Integer> {

    List<CompanyData> findAllByActiveIsTrue();

}
