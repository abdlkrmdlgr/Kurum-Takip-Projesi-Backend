package com.restDeneme.resDeneme.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Exception {


public Exception()
{

}
    private Long id;
    private Date date;
    private String owner;
    private String versiyon;
    private String ip;
    private Long port;
    private String kullaniciId;


}
