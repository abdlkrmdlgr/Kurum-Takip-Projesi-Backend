package com.restDeneme.resDeneme.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Kurum {

    public Kurum() {

    }

    private Long id;
    private String owner;
    private String kurumAdi;
    private String logo;
}
