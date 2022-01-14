package com.restDeneme.resDeneme.Repository;

import com.restDeneme.resDeneme.model.Kurum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KurumRepository  extends CrudRepository<Kurum,Long> {

}
