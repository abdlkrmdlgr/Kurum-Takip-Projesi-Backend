package com.restDeneme.resDeneme.Contoller;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.restDeneme.resDeneme.model.ExceptionLog;
import com.restDeneme.resDeneme.model.IL;
import com.restDeneme.resDeneme.model.Kurum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

@RestController
@RequestMapping("/mert")
public class DenemeController {


    @GetMapping("/kurum")
    public ResponseEntity<List<Kurum>> getKurum() {
        List<Kurum> kurumList2 = new ArrayList<>();
        Faker faker = new Faker(new Locale("tr-TR"));
        generateKurum(kurumList2, faker);

        return new ResponseEntity<>(kurumList2, HttpStatus.CREATED);
    }

    @GetMapping("/kurumList")
    public ResponseEntity<List<Kurum>> getKurumList() {
        List<Kurum> kurumList = new ArrayList<>();
        Faker faker = new Faker(new Locale("tr-TR"));

        kurumList.clear();
        for (int i = 0; i < 10; i++) {
            generateKurum(kurumList, faker);

        }
        return new ResponseEntity<>(kurumList, HttpStatus.CREATED);
    }

    @GetMapping("/hataList")
    public ResponseEntity<List<ExceptionLog>> getHataList() {
        List<ExceptionLog> hataList = new ArrayList<>();
        Faker faker = new Faker(new Locale("tr-TR"));

        hataList.clear();
        for (int i = 0; i < 10; i++) {
            generateHata(hataList, faker, 10);
        }

        return new ResponseEntity<>(hataList, HttpStatus.CREATED);
    }

    @GetMapping("/hata")
    public ResponseEntity<List<ExceptionLog>> getHata() {
        List<ExceptionLog> hataList = new ArrayList<>();
        Faker faker = new Faker(new Locale("tr-TR"));


        generateHata(hataList, faker, 10);
        return new ResponseEntity<>(hataList, HttpStatus.CREATED);
    }

    @PostMapping("/dummyveri/{sayi}")
    public ResponseEntity<List<Kurum>> getDummy(@PathVariable Long sayi) {
        List<Kurum> kurumList = new ArrayList<>();
        Faker faker = new Faker(new Locale("tr-TR"));

        for (int i = 0; i < sayi; i++) {
            generateKurum(kurumList, faker);

        }
        Gson gson;
        try (Writer writer = new FileWriter("exceptionList.json")) {
            gson = new GsonBuilder().create();
            gson.toJson(kurumList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(kurumList, HttpStatus.CREATED);
    }

    @PostMapping("/dummyVeriHataList/{sayi}")
    public void generateDummyHataList(@PathVariable int sayi) {
        List<ExceptionLog> hataList = new ArrayList<>();
        Faker faker = new Faker(new Locale("tr-TR"));

        for (int i = 0; i < sayi; i++) {
            generateHata(hataList, faker, sayi);

        }
        Gson gson;
        try (Writer writer = new FileWriter("exceptionList.json")) {
            gson = new GsonBuilder().create();
            gson.toJson(hataList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @ResponseBody
    @GetMapping(value = "/exceptionList/{sayi}")
    public ResponseEntity<List<ExceptionLog>> getExceptionList(@PathVariable("sayi") int sayi, @RequestBody IL bodyCount, HttpServletResponse response) {
        response.addIntHeader("Total Count", sayi * bodyCount.getCount());
        if (sayi != 1)
            sayi = sayi + bodyCount.getCount();

        List<ExceptionLog> exceptionLogList = jsonReader();
        List<ExceptionLog> arrlist = exceptionLogList.subList(sayi - 1, sayi + bodyCount.getCount() - 1);
        return new ResponseEntity<>(arrlist, HttpStatus.OK);

    }

    @GetMapping("exceptionHata/{sayi}")
    public ExceptionLog exceptionHata(@PathVariable int sayi) {

        List<ExceptionLog> exceptionLogList = jsonReader();
        for (int i = 0; i < exceptionLogList.size(); i++)
            if (exceptionLogList.get(i).getId() == sayi)
                return exceptionLogList.get(i);

        return null;
    }

    @GetMapping("toplam")
    public ResponseEntity<Integer> toplam() {

        List<ExceptionLog> exceptionLogList = jsonReader();

        return new ResponseEntity<>(exceptionLogList.size(), HttpStatus.OK);
    }

    public List<ExceptionLog> jsonReader() {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("exceptionList.json")) {

            // Convert JSON File to Java Object
            Type listType = new TypeToken<List<ExceptionLog>>() {
            }.getType();
            List<ExceptionLog> exceptionLogList = gson.fromJson(reader, listType);

            return exceptionLogList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void generateKurum(List<Kurum> kurumList, Faker faker) {
        Kurum kurum = new Kurum();
        kurum.setKurumAdi(faker.company().name());
        kurum.setId(faker.number().randomNumber());
        kurum.setLogo(faker.company().logo());
        kurum.setOwner(faker.company().catchPhrase());
        kurumList.add(kurum);

    }


    private void generateHata(List<ExceptionLog> hataList, Faker faker, int count) {

        for (int i = 0; i < count; i++) {

            String owner = getOwner(i);
            for (int j = 0; j < 20; j++) {
                ExceptionLog hata = new ExceptionLog();
                hata.setId(faker.number().randomNumber());
                hata.setDate(faker.date().birthday());
                hata.setIp(faker.number().digit());
                hata.setKullaniciId(faker.number().digit());
                hata.setPort(faker.number().randomNumber());
                hata.setVersiyon(faker.number().digit());
                hata.setOwner(owner);

                hataList.add(hata);

            }

        }

    }

    public String getOwner(int index) {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("ownerList.json")) {

            // Convert JSON File to Java Object
            Type listType = new TypeToken<List<String>>() {
            }.getType();
            List<String> staffList = gson.fromJson(reader, listType);
            return staffList.get(index);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
