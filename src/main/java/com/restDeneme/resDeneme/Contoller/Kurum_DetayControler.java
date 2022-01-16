package com.restDeneme.resDeneme.Contoller;

import com.restDeneme.resDeneme.Service.KullaniciService;
import com.restDeneme.resDeneme.Service.Kurum_DetayService;
import com.restDeneme.resDeneme.model.Kullanici;
import com.restDeneme.resDeneme.model.Kurum_Detay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Kurum_DetayControler {

    @Autowired
    private Kurum_DetayService kullaniciService;

    // Save operation
    @PostMapping("/kurum_detay")
    public Kurum_Detay saveKullanici(
            @RequestBody Kurum_Detay kurum_detay)
    {

        return kullaniciService.saveDepartment(kurum_detay);
    }

    // Read operation
    @GetMapping("/kurum_detay")
    public List<Kurum_Detay> fetchKullaniciList()
    {

        return kullaniciService.fetchKullaniciList();
    }

    // Update operation
    @PutMapping("/kurum_detay/{id}")
    public Kurum_Detay
    updateDepartment(@RequestBody Kurum_Detay kurum_detay,
                     @PathVariable("id") Long departmentId)
    {

        return kullaniciService.updateDepartment(
                kurum_detay, departmentId);
    }

    // Delete operation
    @DeleteMapping("/kurum_detay/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                               Long departmentId)
    {

        kullaniciService.deleteDepartmentById(
                departmentId);
        return "Deleted Successfully";
    }
}
