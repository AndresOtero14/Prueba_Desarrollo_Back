package Prueba_desarrollo_back.service;


import Prueba_desarrollo_back.dao.EspecieDao;
import Prueba_desarrollo_back.dto.Especie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EspecieService implements EspecieServiceInterfas {


    private  final Logger log = LoggerFactory.getLogger(EspecieService.class);

    private final EspecieDao especieDao;

    public EspecieService(EspecieDao especieDao) {
        this.especieDao = especieDao;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Especie> findAll() {
        log.debug("Request to get all Especie");
        return especieDao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Especie findOne(int idespecie) {
        log.debug("Request to get Raza : {}", idespecie);
        return especieDao.getById(idespecie);
    }

    @Override
    public Especie save(Especie especie) {
        log.debug("Request to insert Especie : {}", especie);
        return especieDao.insert(especie);
    }

    @Override
    public Especie update(Especie especie) {
        log.debug("Request to get all Especie : {}", especie);
        return especieDao.update(especie);
    }

    @Override
    public void delete(Long idespecie) {
        log.debug("Request to delete Raza : {}", idespecie);
        especieDao.delete(idespecie);

    }
}
