package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.model.Erisim;
import com.restDeneme.resDeneme.model.Kullanici;

import java.util.List;

public interface ErisimService {
    Erisim saveDepartment(Erisim kullanici);

    // read operation
    List<Erisim> fetchErisimList();

    // update operation
    Erisim updateDepartment(Erisim erisim, Long erisimId);

    // delete operation
    void deleteDepartmentById(Long erisimId);
}
