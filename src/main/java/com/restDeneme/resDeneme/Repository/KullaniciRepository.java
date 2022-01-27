package com.restDeneme.resDeneme.Repository;

import com.restDeneme.resDeneme.model.Kullanici;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface KullaniciRepository extends CrudRepository<Kullanici,String>  {

   @Query("FROM Kullanici WHERE kullanici_adi = :username AND kullanici_parola = :password" )
   Kullanici findKullaniciAndPassword(String username, String password );

}


