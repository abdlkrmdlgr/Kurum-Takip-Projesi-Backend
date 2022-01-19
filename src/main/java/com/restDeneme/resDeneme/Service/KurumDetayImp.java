package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.Repository.KurumDetayRepository;
import com.restDeneme.resDeneme.model.KurumDetay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class KurumDetayImp implements KurumDetayService {

    @Autowired
    private KurumDetayRepository kurumDetayRepository;

    // save operation
    @Override
    public KurumDetay saveDepartment(KurumDetay kurum_detay) {
        return kurumDetayRepository.save(kurum_detay);
    }

    // read operation
    @Override
    public List<KurumDetay> fetchKurumDetayList(Long kurumid, Long detayid) {


      return kurumDetayRepository.findByFirstName(detayid,kurumid);

    }

    // update operation
    @Override
    public KurumDetay updateDepartment(KurumDetay kurum_detay, Long kullaniciId) {
        KurumDetay kurDB = kurumDetayRepository.findById(kullaniciId).get();

        if (Objects.nonNull(kurum_detay.getKurum_id()) && !"".equalsIgnoreCase(String.valueOf(kurum_detay.getKurum_id()))) {
            kurDB.getKurum_id();
        }

        if (Objects.nonNull(kurum_detay.getDetey_id()) && !"".equalsIgnoreCase(String.valueOf(kurum_detay.getDetey_id()))) {
            kurDB.getDetey_id();
        }

        if (Objects.nonNull(kurum_detay.getIlk_kirilim()) && !"".equalsIgnoreCase(kurum_detay.getIlk_kirilim())) {
            kurDB.getIlk_kirilim();
        }
        if (Objects.nonNull(kurum_detay.getIkinci_kirilim()) && !"".equalsIgnoreCase(kurum_detay.getIkinci_kirilim())) {
            kurDB.getIkinci_kirilim();
        }



        return kurumDetayRepository.save(kurDB);
    }

    // delete operation
    @Override
    public void deleteDepartmentById(Long departmentId) {
        kurumDetayRepository.deleteById(departmentId);
    }
}
