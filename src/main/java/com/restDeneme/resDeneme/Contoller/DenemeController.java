package com.restDeneme.resDeneme.Contoller;

import com.github.javafaker.Faker;
import com.restDeneme.resDeneme.model.IL;
import com.restDeneme.resDeneme.model.Kurum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    private void generateKurum(List<Kurum> kurumList, Faker faker) {
        Kurum kurum = new Kurum();
        kurum.setKurumAdi(faker.company().name());
        kurum.setId(faker.number().randomNumber());
        kurum.setLogo(faker.company().logo());
        kurum.setOwner(faker.company().catchPhrase());
        kurumList.add(kurum);
    }
}
