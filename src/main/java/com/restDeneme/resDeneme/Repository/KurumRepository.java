package com.restDeneme.resDeneme.Repository;

import com.restDeneme.resDeneme.model.Kurum;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KurumRepository extends CrudRepository<Kurum,Long> {


   @Query(" FROM Kurum a join Erisim b on  a.id=b.kurum_id where b.kullanici_id=?1")

    List<Kurum> findByIdAndAnd(Long id);

}
