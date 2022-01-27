package com.restDeneme.resDeneme.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    private  Long detay_id;
    @Getter
    @Setter
    private Long ilk_kirilim;
    @Getter
    @Setter
    private Long ikinci_kirilim;
}
