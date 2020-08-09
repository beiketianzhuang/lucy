package com.lcehn.lucy.registry.repository;

import com.lcehn.lucy.registry.model.CompanyQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRegistryQuestionRepository extends JpaRepository<CompanyQuestion, Integer> {

    List<CompanyQuestion> findAllByActiveIsTrue();
}
