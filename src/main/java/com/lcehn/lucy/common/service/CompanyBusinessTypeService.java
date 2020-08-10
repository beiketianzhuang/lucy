package com.lcehn.lucy.common.service;

import com.lcehn.lucy.common.model.BusinessType;
import com.lcehn.lucy.common.model.Industry;
import com.lcehn.lucy.common.repository.CompanyBusinessTypeRepository;
import com.lcehn.lucy.common.repository.CompanyIndustryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyBusinessTypeService {

    @Autowired
    private CompanyBusinessTypeRepository companyBusinessTypeRepository;
    @Autowired
    private CompanyIndustryRepository companyIndustryRepository;

    public List<BusinessType> listBusinessTypes() {
        return companyBusinessTypeRepository.findAll();
    }

    public List<Industry> listCompanyIndustries() {
        return companyIndustryRepository.findAll();
    }
}
