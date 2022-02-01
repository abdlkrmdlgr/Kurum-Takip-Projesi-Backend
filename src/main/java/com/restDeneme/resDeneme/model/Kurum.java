package com.restDeneme.resDeneme.model;

import com.restDeneme.resDeneme.dto.KurumDetayDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Kurum {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    @Setter
    private String kurum_adi;
    @Getter
    @Setter
    private String logo;
    @Getter
    @Setter
    private String surum;

    @Getter
    @Setter
    @Transient
    private Long kurumDetayVeriToplam;

    @Getter
    @Setter
    @Transient
    private Long kurumDetayKirilimToplam;
}
