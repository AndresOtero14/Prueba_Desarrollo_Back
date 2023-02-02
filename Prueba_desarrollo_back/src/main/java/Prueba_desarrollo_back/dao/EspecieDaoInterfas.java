package Prueba_desarrollo_back.dao;

import Prueba_desarrollo_back.dto.Especie;


import java.util.List;

public interface EspecieDaoInterfas {

    public List<Especie> getAll();

    public  Especie getById(int idespecie);

    public Especie insert(Especie entity);

    public Especie update(Especie entity);

    public Boolean delete (Long idespecie);


}
