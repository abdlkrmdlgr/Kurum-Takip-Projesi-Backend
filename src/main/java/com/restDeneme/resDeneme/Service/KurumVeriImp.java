package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.Repository.KurumVeriRepository;
import com.restDeneme.resDeneme.model.KurumVeriTablosu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class KurumVeriImp implements KurumVeriService {

    @Autowired
    private KurumVeriRepository kurum_veri_Repository;

    // save operation
    @Override
    public KurumVeriTablosu saveDepartment(KurumVeriTablosu kurum_veri_tablosu) {
        return kurum_veri_Repository.save(kurum_veri_tablosu);
    }

    // read operation
    @Override
    public List<KurumVeriTablosu> fetchKullaniciList(Long detayid,Long kurumid) {


                return kurum_veri_Repository.findkurumdetayid(detayid,kurumid);

    }

    // update operation
    @Override
    public KurumVeriTablosu updateDepartment(KurumVeriTablosu kurum_veri_tablosu, Long kullaniciId) {
        KurumVeriTablosu kurDB = kurum_veri_Repository.findById(kullaniciId).get();

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



        return kurum_veri_Repository.save(kurDB);
    }

    // delete operation
    @Override
    public void deleteDepartmentById(Long departmentId) {
        kurum_veri_Repository.deleteById(departmentId);
    }
}
