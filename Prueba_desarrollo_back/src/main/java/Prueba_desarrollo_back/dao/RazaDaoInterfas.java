package Prueba_desarrollo_back.dao;

import Prueba_desarrollo_back.dto.Raza;


import java.util.List;

public interface RazaDaoInterfas {

    public List<Raza> getAll();

    public Raza getById(int idraza);

    public Raza insert(Raza entity);

    public Raza update(Raza entity);

    public Boolean delete(Long idraza);


}
