package com.restDeneme.resDeneme.Contoller;

import com.restDeneme.resDeneme.Service.*;
import com.restDeneme.resDeneme.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kurum")
public class ApiController {

    @Autowired
    private KurumlarService kurumlarService;

    // Read operation
    @GetMapping("/kurumlar")
    public List<Kurumlar> fetchKurumlarList()
    {

        return kurumlarService.fetchKurumlarList();
    }

    @Autowired
    private Kurum_Veri_TablosuService kurum_veri_tablosuService;

    @GetMapping("/kurum_veri")
    public List<Kurum_Veri_Tablosu> fetchKurumVeriList()
    {

        return kurum_veri_tablosuService.fetchKullaniciList();
    }

    @Autowired
    private Kurum_DetayService kurum_detayService;

    // Read operation
    @GetMapping("/kurum_detay")
    public List<Kurum_Detay> fetchKurumDetayList()
    {

        return kurum_detayService.fetchKurumDetayList();
    }




    @Autowired
    private KullaniciService kullaniciService;

    @GetMapping("/kullanici")
    public List<Kullanici> fetchKullaniciList()
    {

        return kullaniciService.fetchKullaniciList();
    }


    @Autowired
    private ErisimService erisimService;
    @GetMapping("/erisim")
    public List<Erisim> fetchErisimList()
    {

        return erisimService.fetchErisimList();
    }

    @Autowired
    private DetayService detayService;

    @GetMapping("/detay")
    public List<Detay> fetchDetayList()
    {

        return detayService.fetchDetayList();
    }

}
