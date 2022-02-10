package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.Repository.KurumDetayRepository;
import com.restDeneme.resDeneme.dto.KurumDetayDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KurumDetayImp extends BaseService implements KurumDetayService {

    @Autowired
    private KurumDetayRepository kurumDetayRepository;

    // read operation
    @Override
    public List<KurumDetayDTO> fetchKurumDetayList(Long kurumId) {
        //Long kullaniciId =  ((Kullanici) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        //TODO: bu servise herhangi bir şekilde kendisine ait olmayan kurumun detay bilgilerine ulaşılması açığı kapatılacak

       // getKullaniciId().
        return kurumDetayRepository.findKurumDetayListBy(getAuthUser().getId(),kurumId);

    }

    @Override
    public Long sumKurumEsikVerileri(Long kurumId){
        return kurumDetayRepository.sumKurumEsikVerileriBy(kurumId);
    }

    @Override
    public Long sumKurumEsikIkinciVerileri(Long kurumId){
        return  kurumDetayRepository.sumKurumIkinciKirilimToplamBy(kurumId);
    }


}
