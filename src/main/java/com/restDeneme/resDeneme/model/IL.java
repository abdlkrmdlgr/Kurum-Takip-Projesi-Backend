package com.restDeneme.resDeneme.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IL {

    private Date createDate;
    private String id;
    private String name;
}
