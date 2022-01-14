package com.restDeneme.resDeneme.model;

import com.restDeneme.resDeneme.Repository.KurumRepository;
import com.restDeneme.resDeneme.Service.KurumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class KurumServiceImp implements KurumService {
    @Autowired
    private KurumRepository departmentRepository;

    // save operation
    @Override
    public Kurum saveDepartment(Kurum department) {
        return departmentRepository.save(department);
    }

    // read operation
    @Override
    public List<Kurum> fetchDepartmentList() {
        return (List<Kurum>) departmentRepository.findAll();
    }

    // update operation
    @Override
    public Kurum updateDepartment(Kurum kurum, Long kurumId) {
        Kurum kurDB = departmentRepository.findById(kurumId).get();

        if (Objects.nonNull(kurum.getKurumAdi()) && !"".equalsIgnoreCase(kurum.getKurumAdi())) {
            kurDB.getKurumAdi();
        }

        if (Objects.nonNull(kurum.getOwner()) && !"".equalsIgnoreCase(kurum.getOwner())) {
            kurDB.getOwner();
        }

        if (Objects.nonNull(kurum.getLogo()) && !"".equalsIgnoreCase(kurum.getLogo())) {
            kurDB.getLogo();
        }

        return departmentRepository.save(kurDB);
    }

    // delete operation
    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
