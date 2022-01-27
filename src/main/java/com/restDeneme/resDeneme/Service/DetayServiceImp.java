package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.Repository.DetayRepository;
import com.restDeneme.resDeneme.model.Detay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetayServiceImp extends BaseService implements  DetayService{


    @Autowired
    private DetayRepository detayRepository;
    // read operation
    @Override
    public List<Detay> fetchDetayList() {

        return (List<Detay>) detayRepository.findAll();
    }



}
