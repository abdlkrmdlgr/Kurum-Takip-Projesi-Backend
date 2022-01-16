package com.restDeneme.resDeneme.Contoller;

import com.restDeneme.resDeneme.Service.KullaniciService;
import com.restDeneme.resDeneme.model.Kullanici;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KullaniciController {

    @Autowired
    private KullaniciService kullaniciService;

    // Save operation
    @PostMapping("/kullanici")
    public Kullanici saveKullanici(
            @RequestBody Kullanici kullanici)
    {

        return kullaniciService.saveDepartment(kullanici);
    }

    // Read operation
    @GetMapping("/kullanici")
    public List<Kullanici> fetchKullaniciList()
    {

        return kullaniciService.fetchKullaniciList();
    }

    // Update operation
    @PutMapping("/kullanici/{id}")
    public Kullanici
    updateDepartment(@RequestBody Kullanici department,
                     @PathVariable("id") Long departmentId)
    {

        return kullaniciService.updateDepartment(
                department, departmentId);
    }

    // Delete operation
    @DeleteMapping("/kullanici/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                               Long departmentId)
    {

        kullaniciService.deleteDepartmentById(
                departmentId);
        return "Deleted Successfully";
    }
}
