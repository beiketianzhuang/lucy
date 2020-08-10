package com.lcehn.lucy.common.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "industry")
public class Industry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String value;
    private Integer parentId;
    private boolean active;

}
