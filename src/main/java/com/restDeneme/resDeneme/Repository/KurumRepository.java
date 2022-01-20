package com.restDeneme.resDeneme.Repository;

import com.restDeneme.resDeneme.model.Kurum;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KurumRepository extends CrudRepository<Kurum,Long> {


   @Query(" FROM Kurum k join Erisim e on  k.id=e.kurum_id where e.kullanici_id=?1")
   List<Kurum> findKurumWithErisimById(Long kullaniciId);

}
