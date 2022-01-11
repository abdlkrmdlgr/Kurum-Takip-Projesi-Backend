package com.restDeneme.resDeneme.Contoller;

import com.restDeneme.resDeneme.model.IL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/mert")
public class DenemeController {

    private static final List<IL> iller= new ArrayList<>();

    public DenemeController() {
        if(iller.isEmpty()) {
            IL il1 = new IL(new Date(), "06", "Ankara");
            IL il2 = new IL(new Date(), "34", "İstanbul");

            iller.add(il1);
            iller.add(il2);
        }
    }



    @GetMapping
    public ResponseEntity<List<IL>> getIller(){




        return new ResponseEntity<>(iller, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public  ResponseEntity<IL> getIL(@PathVariable String id){
IL result=
iller.stream().filter(il -> il.getId().
        equals(id)).findFirst().orElseThrow(()->new RuntimeException("Bulunamadı"));
    return  new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<IL> createIL(@RequestBody IL newIL){
        newIL.setCreateDate(new Date());
        iller.add(newIL);
        return new ResponseEntity<>(newIL,HttpStatus.CREATED);

    }
}
