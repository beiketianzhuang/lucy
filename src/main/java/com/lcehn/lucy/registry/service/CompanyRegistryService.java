package com.lcehn.lucy.registry.service;

import com.lcehn.lucy.registry.model.CompanyData;
import com.lcehn.lucy.registry.model.CompanyQuestion;
import com.lcehn.lucy.registry.model.CompanyStep;
import com.lcehn.lucy.registry.repository.CompanyRegistryDataRepository;
import com.lcehn.lucy.registry.repository.CompanyRegistryQuestionRepository;
import com.lcehn.lucy.registry.repository.CompanyRegistryStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Service
public class CompanyRegistryService {

    @Autowired
    private CompanyRegistryDataRepository companyRegistryDataRepository;
    @Autowired
    private CompanyRegistryStepRepository companyRegistryStepRepository;
    @Autowired
    private CompanyRegistryQuestionRepository companyRegistryQuestionRepository;

    public List<CompanyData> listCompanyData() {
        return companyRegistryDataRepository.findAllByActiveIsTrue();
    }

    public List<CompanyStep> listCompanySteps() {
        return companyRegistryStepRepository.findAllByActiveIsTrue();
    }

    public List<CompanyQuestion> listCompanyQuestions() {
        List<CompanyQuestion> companyQuestions = companyRegistryQuestionRepository.findAllByActiveIsTrue();
        return companyQuestions.stream().sorted(comparing(CompanyQuestion::getUpdateAt)).collect(Collectors.toList());
    }
}
