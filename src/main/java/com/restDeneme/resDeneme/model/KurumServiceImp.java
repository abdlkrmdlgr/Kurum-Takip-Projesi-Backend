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
    public Kurum updateDepartment(Kurum department, Long departmentId) {
        Kurum depDB = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getKurumAdi()) && !"".equalsIgnoreCase(department.getKurumAdi())) {
            depDB.getKurumAdi();
        }

        if (Objects.nonNull(department.getOwner()) && !"".equalsIgnoreCase(department.getOwner())) {
            depDB.getOwner();
        }

        if (Objects.nonNull(department.getLogo()) && !"".equalsIgnoreCase(department.getLogo())) {
            depDB.getLogo();
        }

        return departmentRepository.save(depDB);
    }

    // delete operation
    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
