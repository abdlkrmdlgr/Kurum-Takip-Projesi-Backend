package com.restDeneme.resDeneme.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Kurum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String owner;
    private String kurumAdi;
    private String logo;


}
