package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.model.Kurum;

import java.util.List;

public interface KurumService {

    Kurum saveDepartment(Kurum department);

    // read operation
    List<Kurum> fetchDepartmentList();

    // update operation
    Kurum updateDepartment(Kurum department, Long departmentId);

    // delete operation
    void deleteDepartmentById(Long departmentId);
}
