package com.restDeneme.resDeneme.Contoller;

import com.restDeneme.resDeneme.Service.*;
import com.restDeneme.resDeneme.dto.KurumDetayDTO;
import com.restDeneme.resDeneme.model.*;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApiController {


    @Autowired
    private KurumService kurumService;
    @Autowired
    private KurumVeriService kurumVeriService;
    @Autowired
    private KurumDetayService kurumDetayService;
    @Autowired
    private DetayService detayService;
    @Autowired
    private KullaniciService kullaniciService;

    /**
     * Pynin sorumlu olduğu kurumları getirecek. Bu amaçla erişim tablosu kullanılmalı
     * @return
     */
    @GetMapping("/login")
    public String login() {
       return kullaniciService.getBasicAuthString();
    }

    /**
     * Pynin sorumlu olduğu kurumları getirecek. Bu amaçla erişim tablosu kullanılmalı
     * @return
     */
    @GetMapping("/kurumlar")
    public List<Kurum> fetchKurumList() {
        List<Kurum> kurumList = kurumService.fetchKurumList();

       for (Kurum kurum : kurumList) {
          Long kurumDetayVeriToplam =  kurumVeriService.sumKurumDetayVeri(kurum.getId());
          kurum.setKurumDetayVeriToplam(kurumDetayVeriToplam);
        }
        //eşik verilerinin TOPLAM kurum eşiği olarak alalım.

        // kurum detayda bu kuruma ait olan detayların ilk kırılım TOPLAM kurum ilk kırılım,
        // ikinci kırılım TOPLAM kurum ikinci kırılım olsun



        //TODO: bu iş için kurumId parametre geçilerek TOPLAMI ilk kırılım ve TOPLAM ikinci kırılımı veren servis methodu yazılacak.

        for(Kurum kurum: kurumList)
        {
            Long kurumVeriKirilimToplam= kurumDetayService.sumKurumEsikVerileri(kurum.getId());
            kurum.setKurumDetayKirilimToplam(kurumVeriKirilimToplam);
        }

        return kurumList;
        //kurum detay dto'da dönmemiz lazım.

    }

    /**
     * Parametre olarak kurumid alır
     * @return
     */
    @GetMapping("/kurum_detay/{kurumId}")
    public List<KurumDetayDTO> fetchKurumDetayList(@PathVariable Long kurumId) {
        return kurumDetayService.fetchKurumDetayList(kurumId);
    }

    @GetMapping("/detay")
    public List<Detay> fetchDetayList() {
        return detayService.fetchDetayList();
    }


    /**
     *
     * Parametre olarak detayid ve kurumid alır.
     *
     */
    @GetMapping("/kurum_veri/{detayid}/{kurumid}")
    public List<KurumVeri> fetchKurumVeriList(@PathVariable Long detayid, @PathVariable Long kurumid)
    {
        return kurumVeriService.fetchKurumVeriList(detayid,kurumid);

    }

 /* @GetMapping("/kullanici")
    public List<Kullanici> fetchKullaniciList() {

        return kullaniciService.fetchKullaniciList();
    }

    // Save operation
    @PostMapping("/kullanici")
    public Kullanici saveKullanici(
            @RequestBody Kullanici kullanici) {

        return kullaniciService.saveDepartment(kullanici);
    }

    @DeleteMapping("/kullanici/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                               Long departmentId) {

        kullaniciService.deleteDepartmentById(
                departmentId);
        return "Deleted Successfully";
    }

*/

    /*
    @GetMapping("/erisim")
    public List<Erisim> fetchErisimList() {

        return erisimService.fetchErisimList();
    }
*/
}
