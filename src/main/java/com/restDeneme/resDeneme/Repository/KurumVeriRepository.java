package com.restDeneme.resDeneme.Repository;

import com.restDeneme.resDeneme.model.KurumDetay;
import com.restDeneme.resDeneme.model.KurumVeriTablosu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KurumVeriRepository extends CrudRepository<KurumVeriTablosu,Long> {

    @Query("FROM KurumVeriTablosu WHERE detay_id = ?1 AND kurum_id = ?2" )
    List<KurumVeriTablosu> findkurumdetayid(Long detayid, Long kurumid );
}
