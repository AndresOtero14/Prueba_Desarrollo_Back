package Prueba_desarrollo_back.service;

import Prueba_desarrollo_back.dto.Amo;


import java.util.List;

public interface AmoServiceInterfas {

    public List<Amo> findAll();

    public Amo findOne( int idamo);

    public  Amo save(Amo application);
    public  Amo update(Amo application);

    public void delete( Long idamo);
}
