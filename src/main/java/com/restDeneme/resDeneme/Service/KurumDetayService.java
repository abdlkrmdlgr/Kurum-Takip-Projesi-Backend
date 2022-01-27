package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.dto.KurumDetayDTO;

import java.util.List;

public interface KurumDetayService {

    // read operation
    List<KurumDetayDTO> fetchKurumDetayList(Long kurumId);

}
