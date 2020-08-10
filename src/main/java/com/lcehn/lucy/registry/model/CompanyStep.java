package com.lcehn.lucy.registry.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "company_step")
public class CompanyStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Transient
    private String number;
    private Integer step;
    private String desc;
    private boolean active;

    public static List<CompanyStep> applyCompanySteps(List<CompanyStep> companyStepList) {
        for (int i = 0; i < companyStepList.size(); i++) {
            CompanyStep companySteps = companyStepList.get(i);
            companySteps.setNumber(applyNumber(i + 1));
        }
        return companyStepList.stream()
                .sorted(Comparator.comparing(CompanyStep::getId))
                .collect(Collectors.toList());
    }

    public static String applyNumber(Integer id) {
        if (id < 10) {
            return "0" + id;
        }
        return String.valueOf(id);
    }

}
