package com.lcehn.lucy.registry.repository;

import com.lcehn.lucy.registry.model.CompanyStep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRegistryStepRepository extends JpaRepository<CompanyStep,Integer> {

    List<CompanyStep> findAllByActiveIsTrue();
}
