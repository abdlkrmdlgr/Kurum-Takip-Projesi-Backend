package com.restDeneme.resDeneme.Service;

import com.restDeneme.resDeneme.Repository.KurumRepository;
import com.restDeneme.resDeneme.model.Kurum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class KurumServiceImp implements KurumService {

    @Autowired
    private KurumRepository kurumRepository;

    // save operation
    @Override
    public Kurum saveKurumlar(Kurum department) {
        return kurumRepository.save(department);
    }

    // read operation
    @Override
    public List<Kurum> fetchKurumList(Long id) {


        return kurumRepository.findKurumWithErisimById(id);
    }

    // update operation
    @Override
    public Kurum updateDepartment(Kurum kurum, Long kurumId) {
        Kurum kurDB = kurumRepository.findById(kurumId).get();

        if (Objects.nonNull(kurum.getKurum_adi()) && !"".equalsIgnoreCase(kurum.getKurum_adi())) {
            kurDB.getKurum_adi();
        }

        if (Objects.nonNull(kurum.getLogo()) && !"".equalsIgnoreCase(kurum.getLogo())) {
            kurDB.getLogo();
        }

        if (Objects.nonNull(kurum.getSurum()) && !"".equalsIgnoreCase(kurum.getSurum())) {
            kurDB.getSurum();
        }

        return kurumRepository.save(kurDB);
    }

    // delete operation
    @Override
    public void deleteDepartmentById(Long departmentId) {
        kurumRepository.deleteById(departmentId);
    }

}
