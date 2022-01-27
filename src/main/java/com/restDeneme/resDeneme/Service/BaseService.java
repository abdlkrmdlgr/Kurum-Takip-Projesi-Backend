package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.model.Erisim;
import com.restDeneme.resDeneme.model.Kullanici;
import org.springframework.security.core.context.SecurityContextHolder;

public class BaseService extends Erisim {


    /**
     * Rest'e authorize olan kullancıı bilgisini verir.
     * @return Kullanici
     */
    public Kullanici getAuthUser()
{
    return ((Kullanici) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
}

}
