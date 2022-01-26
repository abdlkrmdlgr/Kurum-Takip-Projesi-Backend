package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.model.Kullanici;

import java.util.List;

public interface KullaniciService {


    Kullanici findUserNameAndPassword(String username, String password);
}
