package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.model.Kurum;



import java.util.List;

public interface KurumService {


    // read operation
    List<Kurum> fetchKurumList();


    Kurum getKurumBy(Long kurumId);

}
