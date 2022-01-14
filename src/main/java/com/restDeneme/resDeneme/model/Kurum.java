package com.restDeneme.resDeneme.model;

import com.restDeneme.resDeneme.util.DataTransferObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Kurum implements DataTransferObject {

    public Kurum() {

    }

    private Long id;
    private String owner;
    private String kurumAdi;
    private String logo;
}
