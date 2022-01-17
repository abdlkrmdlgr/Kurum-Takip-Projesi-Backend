package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.Repository.DetayRepository;
import com.restDeneme.resDeneme.Repository.ErisimRepository;
import com.restDeneme.resDeneme.model.Detay;
import com.restDeneme.resDeneme.model.Erisim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DetayServiceImp implements  DetayService{


    @Autowired
    private DetayRepository departmentRepository;

    // save operation
    @Override
    public Detay saveDepartment(Detay detay) {
        return departmentRepository.save(detay);
    }

    // read operation
    @Override
    public List<Detay> fetchDetayList() {
        return (List<Detay>) departmentRepository.findAll();
    }


    /**
     * Update
     * @param detay
     * @param detayId
     * @return
     */
    public Detay updateDepartment(Detay detay, Long detayId) {
        Detay kurDB = departmentRepository.findById(detayId).get();

        if (Objects.nonNull(detay.getAdi()) && !"".equalsIgnoreCase(String.valueOf(detay.getAdi()))) {
            kurDB.getAdi();
        }





        return departmentRepository.save(kurDB);
    }

    // delete operation
    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

}
