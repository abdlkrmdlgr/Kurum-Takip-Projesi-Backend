package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.model.KurumDetay;


import java.util.List;

public interface KurumDetayService {

    KurumDetay saveDepartment(KurumDetay kurum_detay);

    // read operation
    List<KurumDetay> fetchKurumDetayList();

    // update operation
    KurumDetay updateDepartment(KurumDetay kurum_detay, Long kurumlarId);

    // delete operation
    void deleteDepartmentById(Long kurumlarId);
}
