package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.model.Kurum_Detay;
import com.restDeneme.resDeneme.model.Kurumlar;

import java.util.List;

public interface Kurum_DetayService {

    Kurum_Detay saveDepartment(Kurum_Detay kurum_detay);

    // read operation
    List<Kurum_Detay> fetchKurumDetayList();

    // update operation
    Kurum_Detay updateDepartment(Kurum_Detay kurum_detay, Long kurumlarId);

    // delete operation
    void deleteDepartmentById(Long kurumlarId);
}
