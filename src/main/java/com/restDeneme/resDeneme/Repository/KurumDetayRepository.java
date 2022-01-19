package com.restDeneme.resDeneme.Repository;

import com.restDeneme.resDeneme.model.KurumDetay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KurumDetayRepository extends CrudRepository<KurumDetay,Long> {

    @Query("FROM KurumDetay WHERE detey_id = ?1 AND kurum_id = ?2" )
    List<KurumDetay> findByFirstName(Long detayid, Long kurumid );

}
