package com.restDeneme.resDeneme.model;

import lombok.*;

import javax.persistence.*;

@Entity
public class Kurum {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    @Setter
    private String owner;
    @Getter
    @Setter
    private String kurumAdi;
    @Getter
    @Setter
    private String logo;



}
