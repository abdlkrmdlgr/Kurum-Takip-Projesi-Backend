package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.model.Kurum;
import com.restDeneme.resDeneme.model.Kurumlar;

import java.util.List;

public interface KurumlarService {
    Kurumlar saveDepartment(Kurumlar department);

    // read operation
    List<Kurumlar> fetchKurumlarList();

    // update operation
    Kurumlar updateDepartment(Kurumlar kurumlar, Long kurumlarId);

    // delete operation
    void deleteDepartmentById(Long kurumlarId);
}
