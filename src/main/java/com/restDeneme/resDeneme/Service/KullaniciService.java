package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.model.Kullanici;

import java.util.List;

public interface KullaniciService {
    Kullanici saveDepartment(Kullanici kullanici);

    // read operation
    List<Kullanici> fetchKullaniciList();

    // update operation
    Kullanici updateDepartment(Kullanici kullanici, Long kullaniciId);

    // delete operation
    void deleteDepartmentById(Long kullaniciId);


}
