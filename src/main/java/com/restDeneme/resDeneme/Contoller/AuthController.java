package com.restDeneme.resDeneme.Contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @RequestMapping("/kullanici")
    public String loginUser(){
        return "Kullanıcı girişi başarılı";
    }


}
