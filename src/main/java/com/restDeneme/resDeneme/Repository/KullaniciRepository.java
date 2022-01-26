package com.restDeneme.resDeneme.Repository;

import com.restDeneme.resDeneme.model.Kullanici;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface KullaniciRepository extends CrudRepository<Kullanici,Long>  {


   @Query("FROM Kullanici WHERE kullanici_adi = ?1 AND kullanici_parola = ?2" )
     Kullanici findKullaniciAndPassword(String kullanici, String parola );
}


