package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.model.Kurum;
;

import java.util.List;

public interface KurumService {
    Kurum saveKurumlar(Kurum department);

    // read operation
    List<Kurum> fetchKurumList(Long id);

    // update operation
    Kurum updateDepartment(Kurum kurumlar, Long kurumlarId);

    // delete operation
    void deleteDepartmentById(Long kurumlarId);
}
