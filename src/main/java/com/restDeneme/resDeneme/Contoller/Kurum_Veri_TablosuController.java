package com.restDeneme.resDeneme.Contoller;

import com.restDeneme.resDeneme.Service.Kurum_DetayService;
import com.restDeneme.resDeneme.Service.Kurum_Veri_TablosuService;
import com.restDeneme.resDeneme.model.Kurum_Detay;
import com.restDeneme.resDeneme.model.Kurum_Veri_Tablosu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Kurum_Veri_TablosuController {
    @Autowired
    private Kurum_Veri_TablosuService kullaniciService;

    // Save operation
    @PostMapping("/kurum_veri")
    public Kurum_Veri_Tablosu saveKullanici(
            @RequestBody Kurum_Veri_Tablosu kurum_veri_tablosu)
    {

        return kullaniciService.saveDepartment(kurum_veri_tablosu);
    }

    // Read operation
    @GetMapping("/kurum_veri")
    public List<Kurum_Veri_Tablosu> fetchKullaniciList()
    {

        return kullaniciService.fetchKullaniciList();
    }

    // Update operation
    @PutMapping("/kurum_veri/{id}")
    public Kurum_Veri_Tablosu
    updateDepartment(@RequestBody Kurum_Veri_Tablosu kurum_detay,
                     @PathVariable("id") Long departmentId)
    {

        return kullaniciService.updateDepartment(
                kurum_detay, departmentId);
    }

    // Delete operation
    @DeleteMapping("/kurum_veri/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                               Long departmentId)
    {

        kullaniciService.deleteDepartmentById(
                departmentId);
        return "Deleted Successfully";
    }
}
