package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.model.KurumDetay;


import java.util.List;

public interface KurumDetayService {

    // read operation
    List<KurumDetay> fetchKurumDetayList(Long kurumid, Long detayid);

}
