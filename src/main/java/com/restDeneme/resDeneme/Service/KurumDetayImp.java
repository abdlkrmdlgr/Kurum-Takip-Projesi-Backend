package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.Repository.KurumDetayRepository;
import com.restDeneme.resDeneme.model.KurumDetay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KurumDetayImp implements KurumDetayService {

    @Autowired
    private KurumDetayRepository kurumDetayRepository;

    // read operation
    @Override
    public List<KurumDetay> fetchKurumDetayList(Long kurumid, Long detayid) {

      return kurumDetayRepository.findKurumDetayBy(detayid,kurumid);

    }

}
