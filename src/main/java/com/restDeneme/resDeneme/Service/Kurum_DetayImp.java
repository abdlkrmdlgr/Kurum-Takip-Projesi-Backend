package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.Repository.KullaniciRepository;
import com.restDeneme.resDeneme.Repository.Kurum_DetayRepository;
import com.restDeneme.resDeneme.model.Kullanici;
import com.restDeneme.resDeneme.model.Kurum_Detay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class Kurum_DetayImp implements Kurum_DetayService {

    @Autowired
    private Kurum_DetayRepository departmentRepository;

    // save operation
    @Override
    public Kurum_Detay saveDepartment(Kurum_Detay kurum_detay) {
        return departmentRepository.save(kurum_detay);
    }

    // read operation
    @Override
    public List<Kurum_Detay> fetchKullaniciList() {
        return (List<Kurum_Detay>) departmentRepository.findAll();
    }

    // update operation
    @Override
    public Kurum_Detay updateDepartment(Kurum_Detay kurum_detay, Long kullaniciId) {
        Kurum_Detay kurDB = departmentRepository.findById(kullaniciId).get();

        if (Objects.nonNull(kurum_detay.getKurum_id()) && !"".equalsIgnoreCase(String.valueOf(kurum_detay.getKurum_id()))) {
            kurDB.getKurum_id();
        }

        if (Objects.nonNull(kurum_detay.getDetey_id()) && !"".equalsIgnoreCase(String.valueOf(kurum_detay.getDetey_id()))) {
            kurDB.getDetey_id();
        }

        if (Objects.nonNull(kurum_detay.getIlk_kirilim()) && !"".equalsIgnoreCase(kurum_detay.getIlk_kirilim())) {
            kurDB.getIlk_kirilim();
        }
        if (Objects.nonNull(kurum_detay.getIkinci_kirilim()) && !"".equalsIgnoreCase(kurum_detay.getIkinci_kirilim())) {
            kurDB.getIkinci_kirilim();
        }



        return departmentRepository.save(kurDB);
    }

    // delete operation
    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
