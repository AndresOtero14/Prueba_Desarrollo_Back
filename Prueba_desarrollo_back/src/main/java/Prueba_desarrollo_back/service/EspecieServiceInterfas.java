package Prueba_desarrollo_back.service;



import Prueba_desarrollo_back.dto.Especie;

import java.util.List;

public interface EspecieServiceInterfas {

    public List<Especie> findAll();

    public  Especie findOne(int idespecie);

    public Especie save(Especie application);

    public Especie update(Especie application);

    public void delete(Long idespecie);

}
