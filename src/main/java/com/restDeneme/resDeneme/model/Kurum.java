package com.restDeneme.resDeneme.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    private String kurum_acik_adi;

    @Getter
    @Setter
    @Transient
    private Long kurumDetayVeriToplam;

    @Getter
    @Setter
    @Transient
    private Long kurumDetayIlkKirilimToplam;

    @Getter
    @Setter
    @Transient
    private Long kurumDetayIkinciKirilimToplam;

    @Getter
    @Setter
    @Transient
    private String status;


    public void generateStatus() {
        if (kurumDetayVeriToplam != null) {
            if (kurumDetayVeriToplam <= kurumDetayIlkKirilimToplam) {
                this.status = "success";
            } else if (kurumDetayVeriToplam <= kurumDetayIkinciKirilimToplam) {
                this.status = "warning";
            } else {
                this.status = "danger";
            }
        }
        else this.status = "success";
    }

    public void generateLogos(){
        if(kurum_adi!=null)
        {
            this.logo="C:\\Users\\mkadi\\Desktop\\res-Deneme-you-2\\src\\main\\resources\\logo\\afad\\afadLogo.png";
        }
    }

}
