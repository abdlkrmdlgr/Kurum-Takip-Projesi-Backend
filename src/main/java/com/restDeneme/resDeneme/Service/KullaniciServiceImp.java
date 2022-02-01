package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.Repository.KullaniciRepository;
import com.restDeneme.resDeneme.model.Kullanici;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class KullaniciServiceImp extends BaseService implements KullaniciService {

    @Autowired
    private KullaniciRepository kullaniciRepository;


    @Override
    public Kullanici findUserNameAndPassword(String username, String password) {

        return kullaniciRepository.findKullaniciAndPassword(username,password);

    }


    @Override
    public String getBasicAuthString() {
        return Base64.getEncoder().encodeToString((getAuthUser().getKullanici_adi()+":"+ getAuthUser().getKullanici_parola()).getBytes());
    }
}
