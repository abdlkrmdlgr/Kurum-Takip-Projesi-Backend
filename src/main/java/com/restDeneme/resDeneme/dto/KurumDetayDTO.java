package com.restDeneme.resDeneme.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class KurumDetayDTO {
    @Getter
    @Setter
    private String detayAdi;

    @Getter
    @Setter
    private Long kurumVeri;

    @Getter
    @Setter
    private Date kurumVeriTarih;

    @Getter
    @Setter
    private String status;

    public KurumDetayDTO(String detayAdi, Long kurumVeri, Date kurumVeriTarih, Long ilkKirilim, Long ikinciKirilim) {
        this.detayAdi = detayAdi;
        this.kurumVeri = kurumVeri;
        this.kurumVeriTarih = kurumVeriTarih;
        if (kurumVeri <= ilkKirilim) {
            this.status = "YESIL";
        } else if (kurumVeri <= ikinciKirilim) {
            this.status = "SARI";
        } else {
            this.status = "KIRMIZI";
        }
    }
}
