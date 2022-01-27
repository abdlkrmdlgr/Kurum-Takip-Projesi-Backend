package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.model.Kullanici;

public interface KullaniciService {


    Kullanici findUserNameAndPassword(String username, String password);
}
