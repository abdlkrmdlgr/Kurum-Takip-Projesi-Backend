package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.Repository.Kurum_Veri_TablosuRepository;
import com.restDeneme.resDeneme.model.Kurum_Detay;
import com.restDeneme.resDeneme.model.Kurum_Veri_Tablosu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class Kurum_Veri_TablosuImp implements Kurum_Veri_TablosuService {

    @Autowired
    private Kurum_Veri_TablosuRepository kurum_veri_tablosuRepository;

    // save operation
    @Override
    public Kurum_Veri_Tablosu saveDepartment(Kurum_Veri_Tablosu kurum_veri_tablosu) {
        return kurum_veri_tablosuRepository.save(kurum_veri_tablosu);
    }

    // read operation
    @Override
    public List<Kurum_Veri_Tablosu> fetchKullaniciList() {
        return (List<Kurum_Veri_Tablosu>) kurum_veri_tablosuRepository.findAll();
    }

    // update operation
    @Override
    public Kurum_Veri_Tablosu updateDepartment(Kurum_Veri_Tablosu kurum_veri_tablosu, Long kullaniciId) {
        Kurum_Veri_Tablosu kurDB = kurum_veri_tablosuRepository.findById(kullaniciId).get();

        if (Objects.nonNull(kurum_veri_tablosu.getKurum_id()) && !"".equalsIgnoreCase(String.valueOf(kurum_veri_tablosu.getKurum_id()))) {
            kurDB.getKurum_id();
        }

        if (Objects.nonNull(kurum_veri_tablosu.getKurum_id()) && !"".equalsIgnoreCase(String.valueOf(kurum_veri_tablosu.getKurum_id()))) {
            kurDB.getKurum_id();
        }

        if (Objects.nonNull(kurum_veri_tablosu.getDetay_id()) && !"".equalsIgnoreCase(String.valueOf(kurum_veri_tablosu.getDetay_id()))) {
            kurDB.getDetay_id();
        }
        if (Objects.nonNull(kurum_veri_tablosu.getKurum_verisi()) && !"".equalsIgnoreCase(kurum_veri_tablosu.getKurum_verisi())) {
            kurDB.getKurum_verisi();
        }
        if (Objects.nonNull(kurum_veri_tablosu.getTarih()) && !"".equalsIgnoreCase(String.valueOf(kurum_veri_tablosu.getTarih()))) {
            kurDB.getTarih();
        }



        return kurum_veri_tablosuRepository.save(kurDB);
    }

    // delete operation
    @Override
    public void deleteDepartmentById(Long departmentId) {
        kurum_veri_tablosuRepository.deleteById(departmentId);
    }
}
