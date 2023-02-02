package Prueba_desarrollo_back.mapper;

import Prueba_desarrollo_back.dto.Especie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EspecieMapper implements RowMapper<Especie> {


    @Override
    public Especie mapRow(ResultSet resultSet, int i) throws SQLException{
        Especie entity = new Especie();
        entity.setIdespecie(resultSet.getInt("idespecie"));
        entity.setNombre(resultSet.getString("nombre"));
        entity.setFk_raza(resultSet.getInt("fk_raza"));
        entity.setEspecie(resultSet);

        return entity;

    }
}
