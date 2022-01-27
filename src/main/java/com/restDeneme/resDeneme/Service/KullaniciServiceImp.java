package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.Repository.KullaniciRepository;
import com.restDeneme.resDeneme.model.Kullanici;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KullaniciServiceImp implements KullaniciService {

    @Autowired
    private KullaniciRepository kullaniciRepository;


    @Override
    public Kullanici findUserNameAndPassword(String username, String password) {

        return kullaniciRepository.findKullaniciAndPassword(username,password);

    }
}
