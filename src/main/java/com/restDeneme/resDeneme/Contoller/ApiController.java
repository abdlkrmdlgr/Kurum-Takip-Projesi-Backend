package com.restDeneme.resDeneme.Contoller;

import com.restDeneme.resDeneme.Service.*;
import com.restDeneme.resDeneme.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private KurumService kurumService;
    @Autowired
    private KurumVeriService kurumVeriService;
    @Autowired
    private KurumDetayService kurumDetayService;
  /*  private KullaniciService kullaniciService;
    @Autowired
    private ErisimService erisimService;
    */

    @Autowired
    private DetayService detayService;

// WARNING: Yapılan istek kullanıcının sadece sorumlu olduğu kurumların verlerini getirir.

    /**
     * Pynin sorumlu olduğu kurumları getirecek. Bu amaçla erişim tablosu kullanılmalı
     * @return
     */
    @GetMapping("/kurumlar/{id}")
    public List<Kurum> fetchKurumList(@PathVariable Long id) {

        return kurumService.fetchKurumList(id);
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

    /**
     * Parametre olarak kurumid ve detayid alır.
     * @return
     */
    @GetMapping("/kurum_detay/{kurumid}/{detayid}")
    public List<KurumDetay> fetchKurumDetayList(@PathVariable Long kurumid, @PathVariable Long detayid) {



        return kurumDetayService.fetchKurumDetayList(kurumid,detayid);

    }


    @GetMapping("/detay")
    public List<Detay> fetchDetayList() {

        return detayService.fetchDetayList();
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
