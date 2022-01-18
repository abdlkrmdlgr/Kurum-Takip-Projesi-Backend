package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.Repository.KullaniciRepository;
import com.restDeneme.resDeneme.model.Kullanici;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class KullaniciServiceImp implements KullaniciService {

    @Autowired
    private KullaniciRepository departmentRepository;

    // save operation
    @Override
    public Kullanici saveDepartment(Kullanici department) {
        return departmentRepository.save(department);
    }

    // read operation
    @Override
    public List<Kullanici> fetchKullaniciList() {
        return (List<Kullanici>) departmentRepository.findAll();
    }

    // update operation
    @Override
    public Kullanici updateDepartment(Kullanici kullanici, Long kullaniciId) {
        Kullanici kurDB = departmentRepository.findById(kullaniciId).get();

        if (Objects.nonNull(kullanici.getKullanici_adi()) && !"".equalsIgnoreCase(kullanici.getKullanici_adi())) {
            kurDB.getKullanici_adi();
        }

        if (Objects.nonNull(kullanici.getKullanici_parola()) && !"".equalsIgnoreCase(kullanici.getKullanici_parola())) {
            kurDB.getKullanici_parola();
        }



        return departmentRepository.save(kurDB);
    }

    // delete operation
    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
