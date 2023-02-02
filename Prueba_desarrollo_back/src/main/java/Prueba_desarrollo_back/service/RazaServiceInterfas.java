package Prueba_desarrollo_back.service;

import Prueba_desarrollo_back.dto.Raza;


import java.util.List;

public interface RazaServiceInterfas {

    public List<Raza> findAll();

    public Raza findOne(int idraza);

    public Raza save(Raza application);
    public Raza update(Raza application);

    public void delete(Long idraza);

}
