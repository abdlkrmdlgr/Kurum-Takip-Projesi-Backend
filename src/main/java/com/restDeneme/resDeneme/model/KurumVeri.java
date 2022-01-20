package com.restDeneme.resDeneme.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class KurumVeri {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    @Setter
    private Long kurum_id;
    @Getter
    @Setter
    private Long detay_id;
    @Getter
    @Setter
    private String kurum_verisi;
    @Getter
    @Setter
    private Date tarih;
}
