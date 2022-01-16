package com.restDeneme.resDeneme.Contoller;

import com.restDeneme.resDeneme.Service.ErisimService;
import com.restDeneme.resDeneme.Service.KullaniciService;
import com.restDeneme.resDeneme.model.Erisim;
import com.restDeneme.resDeneme.model.Kullanici;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ErisimController {
    @Autowired
    private ErisimService kullaniciService;

    // Save operation
    @PostMapping("/erisim")
    public Erisim saveKullanici(
            @RequestBody Erisim erisim)
    {

        return kullaniciService.saveDepartment(erisim);
    }

    // Read operation
    @GetMapping("/erisim")
    public List<Erisim> fetchKullaniciList()
    {

        return kullaniciService.fetchKullaniciList();
    }

    // Update operation
    @PutMapping("/erisim/{id}")
    public Erisim
    updateDepartment(@RequestBody Erisim erisim,
                     @PathVariable("id") Long departmentId)
    {

        return kullaniciService.updateDepartment(
                erisim, departmentId);
    }

    // Delete operation
    @DeleteMapping("/erisim/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                               Long departmentId)
    {

        kullaniciService.deleteDepartmentById(
                departmentId);
        return "Deleted Successfully";
    }
}
