package com.restDeneme.resDeneme.Repository;

import com.restDeneme.resDeneme.model.KurumDetay;
import com.restDeneme.resDeneme.dto.KurumDetayDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KurumDetayRepository extends CrudRepository<KurumDetay,Long> {

    @Query("SELECT new com.restDeneme.resDeneme.dto.KurumDetayDTO(d.adi, kv.kurum_verisi,kv.tarih,kd.ilk_kirilim,kd.ikinci_kirilim) " +
            "FROM KurumDetay kd,Detay d, Erisim e,KurumVeri kv " +
            "where kd.detay_id = d.id and kd.kurum_id=e.kurum_id and d.id=kv.detay_id and kv.kurum_id = :kurumId and e.kullanici_id = :kullaniciId and e.kurum_id=:kurumId")
    List<KurumDetayDTO> findKurumDetayListBy(Long kullaniciId , Long kurumId);

}
