package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.Repository.KurumVeriRepository;
import com.restDeneme.resDeneme.model.KurumVeri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KurumVeriImp implements KurumVeriService {

    @Autowired
    private KurumVeriRepository kurumVeriRepository;

    // read operation
    @Override
    public List<KurumVeri> fetchKurumVeriList(Long detayid, Long kurumid) {
        return kurumVeriRepository.findKurumVeriBy(detayid,kurumid);
    }

    @Override
    public Long sumKurumDetayVeri(Long kurumId) {
        return  kurumVeriRepository.sumKurumDetayVerisiBy(kurumId);
    }


}
