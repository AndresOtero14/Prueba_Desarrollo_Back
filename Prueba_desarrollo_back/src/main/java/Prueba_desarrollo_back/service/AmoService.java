package Prueba_desarrollo_back.service;

import Prueba_desarrollo_back.dao.AmoDao;
import Prueba_desarrollo_back.dto.Amo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class AmoService implements AmoServiceInterfas{

    private  final Logger log = LoggerFactory.getLogger(AmoService.class);


    private final AmoDao amoDao;

    public AmoService(AmoDao amoDao) {
        this.amoDao = amoDao;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Amo> findAll() {
        log.debug("Request to get all Amo");
        return amoDao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Amo findOne(int idamo) {
        log.debug("Request to get Amo : {}", idamo);
        return amoDao.getById(idamo);
    }

    @Override
    public Amo save(Amo amo) {
        log.debug("Request to insery Amo : {}" , amo);
        return amoDao.insert(amo);
    }

    @Override
    public Amo update(Amo amo) {
        log.debug("Request to get all  Amo : {}", amo);
        return amoDao.update(amo);
    }

    @Override
    public void delete(Long idamo) {
        log.debug("Request to delete Amo : {}", idamo);
        amoDao.delete(idamo);

    }
}
