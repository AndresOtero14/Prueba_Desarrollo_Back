package Prueba_desarrollo_back.service;

import Prueba_desarrollo_back.dao.PacienteDao;
import Prueba_desarrollo_back.dto.Paciente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PacienteService implements PacienteServiceInterfas {

    private  final Logger log = LoggerFactory.getLogger(PacienteService.class);

   private final PacienteDao pacienteDao;

    public PacienteService(PacienteDao pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Paciente> findAll() {
        log.debug("Request to get all Paciente");
        return pacienteDao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Paciente findOne(int idpaciente) {
        log.debug("Request to get Paciente : {} ", idpaciente);
        return pacienteDao.getById(idpaciente);
    }

    @Override
    public Paciente save(Paciente paciente) {
        log.debug("Request to insert Paciente : {}", paciente);
        return  pacienteDao.insert(paciente);
    }

    @Override
    public Paciente update(Paciente paciente) {
        log.debug("Request to get all Paciente : {}", paciente);
        return pacienteDao.update(paciente);
    }

    @Override
    public void delete(int idpaciente) {
        log.debug("Request to delete paciente : {}", idpaciente);
        pacienteDao.delete(idpaciente);
    }
}
