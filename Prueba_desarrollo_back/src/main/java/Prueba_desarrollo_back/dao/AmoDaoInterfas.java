package Prueba_desarrollo_back.dao;

import Prueba_desarrollo_back.dto.Amo;


import java.util.List;

public interface AmoDaoInterfas {

    public List<Amo> getAll();

    public Amo getById( int idamo );

    public Amo insert(Amo entity);

    public Amo update(Amo entity);

    public Boolean delete(Long idamo);
}
