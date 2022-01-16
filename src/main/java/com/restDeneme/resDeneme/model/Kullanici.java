package com.restDeneme.resDeneme.model;

import lombok.*;

import javax.persistence.*;


@Entity
public class Kullanici {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    @Setter
    private String kullanici_adi;
    @Getter
    @Setter
    private String kullanici_parola;

}
