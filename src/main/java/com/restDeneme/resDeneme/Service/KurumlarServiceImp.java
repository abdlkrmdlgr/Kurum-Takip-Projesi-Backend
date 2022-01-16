package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.Repository.KurumRepository;
import com.restDeneme.resDeneme.Repository.KurumlarRepository;
import com.restDeneme.resDeneme.model.Kurum;
import com.restDeneme.resDeneme.model.Kurumlar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class KurumlarServiceImp implements  KurumlarService{

    @Autowired
    private KurumlarRepository departmentRepository;

    // save operation
    @Override
    public Kurumlar saveDepartment(Kurumlar department) {
        return departmentRepository.save(department);
    }

    // read operation
    @Override
    public List<Kurumlar> fetchDepartmentList() {
        return (List<Kurumlar>) departmentRepository.findAll();
    }

    // update operation
    @Override
    public Kurumlar updateDepartment(Kurumlar kurum, Long kurumId) {
        Kurumlar kurDB = departmentRepository.findById(kurumId).get();

        if (Objects.nonNull(kurum.getKurum_adi()) && !"".equalsIgnoreCase(kurum.getKurum_adi())) {
            kurDB.getKurum_adi();
        }

        if (Objects.nonNull(kurum.getLogo()) && !"".equalsIgnoreCase(kurum.getLogo())) {
            kurDB.getLogo();
        }

        if (Objects.nonNull(kurum.getSurum()) && !"".equalsIgnoreCase(kurum.getSurum())) {
            kurDB.getSurum();
        }

        return departmentRepository.save(kurDB);
    }

    // delete operation
    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

}
