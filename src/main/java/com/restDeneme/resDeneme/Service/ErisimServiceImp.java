package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.Repository.ErisimRepository;
import com.restDeneme.resDeneme.Repository.KullaniciRepository;
import com.restDeneme.resDeneme.model.Erisim;
import com.restDeneme.resDeneme.model.Kullanici;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ErisimServiceImp implements ErisimService {

    @Autowired
    private ErisimRepository departmentRepository;

    // save operation
    @Override
    public Erisim saveDepartment(Erisim department) {
        return departmentRepository.save(department);
    }

    // read operation
    @Override
    public List<Erisim> fetchKullaniciList() {
        return (List<Erisim>) departmentRepository.findAll();
    }

    // update operation
    @Override
    public Erisim updateDepartment(Erisim erisim, Long erisimId) {
        Erisim kurDB = departmentRepository.findById(erisimId).get();

        if (Objects.nonNull(erisim.getKullanici_id()) && !"".equalsIgnoreCase(String.valueOf(erisim.getKullanici_id()))) {
            kurDB.getKullanici_id();
        }

        if (Objects.nonNull(erisim.getKurum_id()) && !"".equalsIgnoreCase(String.valueOf(erisim.getKurum_id()))) {
            kurDB.getKurum_id();
        }



        return departmentRepository.save(kurDB);
    }

    // delete operation
    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }


}
