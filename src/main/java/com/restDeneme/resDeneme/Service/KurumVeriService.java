package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.model.KurumVeriTablosu;

import java.util.List;

public interface KurumVeriService {

    KurumVeriTablosu saveDepartment(KurumVeriTablosu kurum_veri_tablosu);

    // read operation
    List<KurumVeriTablosu> fetchKullaniciList();

    // update operation
    KurumVeriTablosu updateDepartment(KurumVeriTablosu kurum_veri_tablosu, Long kurumlarId);

    // delete operation
    void deleteDepartmentById(Long kurumlarId);
}
