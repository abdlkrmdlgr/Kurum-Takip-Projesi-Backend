package com.restDeneme.resDeneme.Contoller;

import com.restDeneme.resDeneme.Service.KurumlarService;
import com.restDeneme.resDeneme.model.Kurum;
import com.restDeneme.resDeneme.model.Kurumlar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KurumlarController {

    @Autowired
    private KurumlarService kurumlarService;

    // Save operation
    @PostMapping("/kurumlar")
    public Kurumlar saveDepartment(
            @RequestBody Kurumlar department)
    {

        return kurumlarService.saveDepartment(department);
    }

    // Read operation
    @GetMapping("/kurumlar")
    public List<Kurumlar> fetchDepartmentList()
    {

        return kurumlarService.fetchDepartmentList();
    }

    // Update operation
    @PutMapping("/kurumlar/{id}")
    public Kurumlar
    updateDepartment(@RequestBody Kurumlar department,
                     @PathVariable("id") Long departmentId)
    {

        return kurumlarService.updateDepartment(
                department, departmentId);
    }

    // Delete operation
    @DeleteMapping("/kurumlar/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                               Long departmentId)
    {

        kurumlarService.deleteDepartmentById(
                departmentId);
        return "Deleted Successfully";
    }
}
