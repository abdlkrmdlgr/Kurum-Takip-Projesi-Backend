package com.restDeneme.resDeneme.Contoller;

import com.restDeneme.resDeneme.Service.*;
import com.restDeneme.resDeneme.dto.KurumDetayDTO;
import com.restDeneme.resDeneme.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApiController implements WebMvcConfigurer {


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

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/logo/**")
                .addResourceLocations("classpath:/logo/");
    }

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

            Long kurumVeriKirilimToplam= kurumDetayService.sumKurumEsikVerileri(kurum.getId());
            kurum.setKurumDetayIlkKirilimToplam(kurumVeriKirilimToplam);

            Long kurumVeriIkinciKiririlimToplam= kurumDetayService.sumKurumEsikIkinciVerileri((kurum.getId()));
            kurum.setKurumDetayIkinciKirilimToplam(kurumVeriIkinciKiririlimToplam);

            kurum.generateStatus();
            kurum.generateLogos();
        }

        return kurumList;
        //kurum detay dto'da dönmemiz lazım.
    }


    @GetMapping("/kurumlar/{kurumId}")
    public Kurum getKurumBy(@PathVariable Long kurumId){
        return kurumService.getKurumBy(kurumId);
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


    @GetMapping(value = "/logo/{owner}")
    public @ResponseBody String getImage(@PathVariable String owner) throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("/logo/"+owner+"/"+owner +"logo.png");
        //oturum açan kullanıcının ownerlarından birisi mi kontrol eklenebilir.
        return Base64.getEncoder().encodeToString(in.readAllBytes());
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

    /** TODO:
     * 1- Swagger - Yapılacak İş
     * 2- Staj Raporu
     *      2.1 - Amaç
     *      2.2 - Kapsam
     *      2.3 - İş Kuralları
     *      2.4 - UML diagramı
     *      2.5 - SpringBoot Nedir?
     *      2.6 - Maven Nedir
     *      2.7 - Hibernate(ORM) Nedir?
     *      2.8 - Web Servis nedir? Neden Web Servis?
     *      2.9 - Rest Nedir? Neden Rest? Rest Best Practice!
     *      2.10- Postman Nedir? Neden kullanırız?
     *      2.11- React ve Ionic Nedir?
     *      2.12- Axios Nedir?
     *      2.13- Versiyon Kontrol Sistemleri nelerdir?
     *      2.14- Neden VCS Kullanırız?
     *      2.15- Git Nedir?
     *      2.16- Clean Code nedir? Neden Clean Code?
     *      2.17- Method ve değişken isimlendirmelerinde nelere dikkat edilmeli.
     *      2.17- Comment Satırı Nedir? Önemi nedir?
     *      2.18- Yazılım projelerinde dokümantasyon neden önemlidir?
     *      2.19- Web Servis dokümantasyon araçları nelerdir?
     *      2.20- Swagger Nedir? Amacı nedir? Nasıl kullanılır.
     *      2.21- Neler Öğrendim?
     *      2.22- Nelerde zorlandım?
     *      2.23- Ne gibi eksikliklerimi gördüm
     *      2.24- Staj öncesi ve sonrası sektörel ilerleme planımda neler değişti?
     */

}
