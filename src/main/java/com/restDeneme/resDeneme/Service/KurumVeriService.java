package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.model.KurumVeri;

import java.util.List;

public interface KurumVeriService {

    // read operation
    List<KurumVeri> fetchKurumVeriList(Long detayid, Long kurumid);


}
