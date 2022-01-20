package com.restDeneme.resDeneme.Repository;

import com.restDeneme.resDeneme.model.KurumVeri;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KurumVeriRepository extends CrudRepository<KurumVeri,Long> {

    @Query("FROM KurumVeri WHERE detay_id = ?1 AND kurum_id = ?2" )
    List<KurumVeri> findKurumVeriBy(Long detayid, Long kurumid );
}
