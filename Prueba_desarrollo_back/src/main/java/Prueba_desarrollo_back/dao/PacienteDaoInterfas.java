package Prueba_desarrollo_back.dao;

import Prueba_desarrollo_back.dto.Paciente;


import java.util.List;

public interface PacienteDaoInterfas {

    public List<Paciente> getAll();
    public Paciente getById(int idpacinete);

    public Paciente insert( Paciente entity);

    public Paciente update( Paciente entity);

    public Boolean delete(int idpacinete);
}
