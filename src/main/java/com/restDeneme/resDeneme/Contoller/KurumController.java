package com.restDeneme.resDeneme.Contoller;

import com.restDeneme.resDeneme.Service.KurumService;
import com.restDeneme.resDeneme.model.Kurum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class KurumController {

    @Autowired
    private KurumService departmentService;

    // Save operation
    @PostMapping("/departmants")
    public Kurum saveDepartment(
             @RequestBody Kurum department)
    {

        return departmentService.saveDepartment(department);
    }

    // Read operation
    @GetMapping("/departments")
    public List<Kurum> fetchDepartmentList()
    {

        return departmentService.fetchDepartmentList();
    }

    // Update operation
    @PutMapping("/departments/{id}")
    public Kurum
    updateDepartment(@RequestBody Kurum department,
                     @PathVariable("id") Long departmentId)
    {

        return departmentService.updateDepartment(
                department, departmentId);
    }

    // Delete operation
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                               Long departmentId)
    {

        departmentService.deleteDepartmentById(
                departmentId);
        return "Deleted Successfully";
    }
}
