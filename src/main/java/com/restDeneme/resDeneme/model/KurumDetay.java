package com.restDeneme.resDeneme.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KurumDetay {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    @Setter
    private Long kurum_id;
    @Getter
    @Setter
    private  Long detey_id;
    @Getter
    @Setter
    private String ilk_kirilim;
    @Getter
    @Setter
    private String ikinci_kirilim;

}
