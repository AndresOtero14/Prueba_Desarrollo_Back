package Prueba_desarrollo_back.mapper;

import Prueba_desarrollo_back.dto.Raza;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RazaMapper implements RowMapper<Raza> {

    @Override
    public Raza mapRow(ResultSet resultSet, int i) throws SQLException{
        Raza  entity = new Raza();
        entity.setIdraza(resultSet.getInt("idraza"));
        entity.setNombre(resultSet.getString("nombre"));
        entity.setraza(resultSet);
        return  entity;
    }
}
