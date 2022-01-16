package com.restDeneme.resDeneme.Contoller;

import com.restDeneme.resDeneme.Service.DetayService;
import com.restDeneme.resDeneme.Service.ErisimService;
import com.restDeneme.resDeneme.model.Detay;
import com.restDeneme.resDeneme.model.Erisim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DetayController {

    @Autowired
    private DetayService kullaniciService;

    // Save operation
    @PostMapping("/detay")
    public Detay saveKullanici(
            @RequestBody Detay detay)
    {

        return kullaniciService.saveDepartment(detay);
    }

    // Read operation
    @GetMapping("/detay")
    public List<Detay> fetchKullaniciList()
    {

        return kullaniciService.fetchKullaniciList();
    }

    // Update operation
    @PutMapping("/detay/{id}")
    public Detay
    updateDepartment(@RequestBody Detay detay,
                     @PathVariable("id") Long departmentId)
    {

        return kullaniciService.updateDepartment(
                detay, departmentId);
    }

    // Delete operation
    @DeleteMapping("/detay/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                               Long departmentId)
    {

        kullaniciService.deleteDepartmentById(
                departmentId);
        return "Deleted Successfully";
    }
}
