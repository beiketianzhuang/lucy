package com.lcehn.lucy.registry.controller;

import com.lcehn.lucy.registry.model.CompanyData;
import com.lcehn.lucy.registry.model.CompanyQuestion;
import com.lcehn.lucy.registry.model.CompanyStep;
import com.lcehn.lucy.registry.service.CompanyRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.lcehn.lucy.registry.model.CompanyData.applyCompanyData;

@RestController
public class CompanyRegistryController {

    @Autowired
    private CompanyRegistryService companyRegistryService;


    /**
     * 获取工商注册材料
     * @return
     */
    @CrossOrigin(value = "*")
    @GetMapping(value = "/companies/registry/data")
    public List<CompanyData> listCompanyData() {
        List<CompanyData> companyDataList = companyRegistryService.listCompanyData();
        return applyCompanyData(companyDataList);
    }


    @GetMapping(value = "/companies/registry/steps")
    public List<CompanyStep> listCompanySteps() {
        return companyRegistryService.listCompanySteps();
    }

    @GetMapping(value = "/companies/registry/questions")
    public List<CompanyQuestion> listCompanyQuestions() {
        return companyRegistryService.listCompanyQuestions();
    }
}
