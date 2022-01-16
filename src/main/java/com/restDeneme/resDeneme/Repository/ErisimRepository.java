package com.restDeneme.resDeneme.Repository;

import com.restDeneme.resDeneme.model.Erisim;
import com.restDeneme.resDeneme.model.Kullanici;
import org.springframework.data.repository.CrudRepository;

public interface ErisimRepository  extends CrudRepository<Erisim,Long> {
}
