package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.model.Detay;
import com.restDeneme.resDeneme.model.Erisim;

import java.util.List;

public interface DetayService {

    Detay saveDepartment(Detay detay);

    // read operation
    List<Detay> fetchDetayList();

    // update operation
    Detay updateDepartment(Detay detay, Long detayId);

    // delete operation
    void deleteDepartmentById(Long detayId);

}
