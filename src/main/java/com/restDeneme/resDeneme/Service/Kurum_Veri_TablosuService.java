package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.model.Kurum_Veri_Tablosu;

import java.util.List;

public interface Kurum_Veri_TablosuService {

    Kurum_Veri_Tablosu saveDepartment(Kurum_Veri_Tablosu kurum_veri_tablosu);

    // read operation
    List<Kurum_Veri_Tablosu> fetchKullaniciList();

    // update operation
    Kurum_Veri_Tablosu updateDepartment(Kurum_Veri_Tablosu kurum_veri_tablosu, Long kurumlarId);

    // delete operation
    void deleteDepartmentById(Long kurumlarId);
}
