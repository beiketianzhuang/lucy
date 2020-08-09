package com.lcehn.lucy.registry.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "company_data")
public class CompanyData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Transient
    private String number;
    private Integer dataOrder;
    private String desc;
    private boolean active;

    /**
     * 业务类型：个体户、有限责任公司、分公司、个人独资等
     */
    private String businessType;

    public static List<CompanyData> applyCompanyData(List<CompanyData> companyDataList) {
        for (int i = 0; i < companyDataList.size(); i++) {
            CompanyData companyData = companyDataList.get(i);
            companyData.setNumber(applyNumber(i + 1));
        }
        return companyDataList.stream()
                .sorted(Comparator.comparing(CompanyData::getId))
                .collect(Collectors.toList());
    }

    public static String applyNumber(Integer id) {
        if (id < 10) {
            return "0" + id;
        }
        return String.valueOf(id);
    }
}
