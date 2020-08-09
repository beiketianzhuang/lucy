package com.lcehn.lucy.registry.model;

import lombok.Data;

import javax.persistence.*;

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

}
