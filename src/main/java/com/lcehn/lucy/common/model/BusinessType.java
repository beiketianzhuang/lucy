package com.lcehn.lucy.common.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "business_type")
public class BusinessType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String value;
    private float price;
    private boolean active;

}
