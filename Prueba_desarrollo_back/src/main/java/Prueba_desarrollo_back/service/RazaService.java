package Prueba_desarrollo_back.service;


import Prueba_desarrollo_back.dao.RazaDao;
import Prueba_desarrollo_back.dto.Raza;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class RazaService implements RazaServiceInterfas{


    private  final Logger log = LoggerFactory.getLogger(RazaService.class);


    private final RazaDao razaDao;

    public RazaService(RazaDao razaDao) {
        this.razaDao = razaDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Raza> findAll() {
        log.debug("Request to get all Raza");
        return razaDao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Raza findOne(int idraza) {
        log.debug("Request to get Raza: {}", idraza);
        return razaDao.getById(idraza);
    }

    @Override
    public Raza save(Raza raza) {
        log.debug("Request to insert Raza : {}", raza);
        return razaDao.insert(raza);
    }

    @Override
    public Raza update(Raza raza) {
        log.debug("Request to get all Raza : {}",raza);
        return razaDao.update(raza);
    }

    @Override
    public void delete(Long idraza) {
        log.debug("Request to delete Raza : {}", idraza);
        razaDao.delete(idraza);
    }
}
