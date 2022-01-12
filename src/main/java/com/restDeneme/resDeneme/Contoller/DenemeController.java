package com.restDeneme.resDeneme.Contoller;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.restDeneme.resDeneme.model.Exception;
import com.restDeneme.resDeneme.model.IL;
import com.restDeneme.resDeneme.model.Kurum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

@RestController
@RequestMapping("/mert")
public class DenemeController {

    private static final List<IL> iller = new ArrayList<>();

    public DenemeController() {
        if (iller.isEmpty()) {
            IL il1 = new IL(new Date(), "06", "Ankara");
            IL il2 = new IL(new Date(), "34", "İstanbul");

            iller.add(il1);
            iller.add(il2);
        }
    }


    @GetMapping
    public ResponseEntity<List<IL>> getIller() {


        return new ResponseEntity<>(iller, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<IL> getIL(@PathVariable String id) {
        IL result =
                iller.stream().filter(il -> il.getId().
                        equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Bulunamadı"));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<IL> createIL(@RequestBody IL newIL) {
        newIL.setCreateDate(new Date());
        iller.add(newIL);
        return new ResponseEntity<>(newIL, HttpStatus.CREATED);

    }

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
    public ResponseEntity<List<Exception>> getHataList() {
        List<Exception> hataList = new ArrayList<>();
        Faker faker = new Faker(new Locale("tr-TR"));

        hataList.clear();
        for (int i = 0; i < 10; i++) {
            generateHata(hataList, faker, 10);
        }


        return new ResponseEntity<>(hataList, HttpStatus.CREATED);
    }

    @GetMapping("/hata")
    public ResponseEntity<List<Exception>> getHata() {
        List<Exception> hataList = new ArrayList<>();
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
        try (Writer writer = new FileWriter("Output.json")) {
            gson = new GsonBuilder().create();
            gson.toJson(kurumList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(kurumList, HttpStatus.CREATED);
    }

    private void generateKurum(List<Kurum> kurumList, Faker faker) {
        Kurum kurum = new Kurum();
        kurum.setKurumAdi(faker.company().name());
        kurum.setId(faker.number().randomNumber());
        kurum.setLogo(faker.company().logo());
        kurum.setOwner(faker.company().catchPhrase());
        kurumList.add(kurum);


    }


    private void generateHata(List<Exception> hataList, Faker faker, int count) {


        for (int i = 0; i < count; i++) {

            for(int j=0;j<50;j++)
            {
                Exception hata = new Exception();
                hata.setId(faker.number().randomNumber());
                hata.setDate(faker.date().birthday());
                hata.setIp(faker.number().digit());
                hata.setKullaniciId(faker.number().digit());
                hata.setPort(faker.number().randomNumber());
                hata.setVersiyon(faker.number().digit());
                hata.setOwner(getOwner(count).toString());


                hataList.add(hata);

            }


        getOwner(i);

        }


    }

    public List<String> getOwner(int index) {
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

    }
}
