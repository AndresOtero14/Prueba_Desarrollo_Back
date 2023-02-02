package Prueba_desarrollo_back.service;

import Prueba_desarrollo_back.dto.Paciente;

import java.util.List;

public interface PacienteServiceInterfas {

    public List<Paciente> findAll();

    public Paciente findOne(int idpaciente);

    public Paciente save(Paciente  application);

    public Paciente update(Paciente  application);

    public void delete(int idpaciente);
}
