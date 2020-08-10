package com.lcehn.lucy.common.controller;

import com.lcehn.lucy.common.model.BusinessType;
import com.lcehn.lucy.common.model.Industry;
import com.lcehn.lucy.common.repository.CompanyBusinessTypeRepository;
import com.lcehn.lucy.common.service.CompanyBusinessTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyCommonController {

    @Autowired
    private CompanyBusinessTypeService companyBusinessTypeService;

    @GetMapping(value = "/companies/commons/business-types")
    public List<BusinessType> listCompanyBusinessTypes() {
        return companyBusinessTypeService.listBusinessTypes();
    }

    @GetMapping(value = "/companies/commons/industries")
    public List<Industry> listCompanyIndustries() {
        return companyBusinessTypeService.listCompanyIndustries();
    }

}
