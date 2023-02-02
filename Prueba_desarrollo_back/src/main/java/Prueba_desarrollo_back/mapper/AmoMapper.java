package Prueba_desarrollo_back.mapper;

import Prueba_desarrollo_back.dto.Amo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AmoMapper implements RowMapper<Amo> {

    @Override
    public Amo mapRow(ResultSet resultSet, int i) throws SQLException{
        Amo entity = new Amo();
        entity.setIdamo(resultSet.getInt("idamo"));
        entity.setTipoid(resultSet.getString("tipoid"));
        entity.setNombre(resultSet.getString("nombre"));
        entity.setTelefono(resultSet.getString("telefono"));
        entity.setCiudad(resultSet.getString("ciudad"));
        entity.setDireccion(resultSet.getString("direccion"));
        entity.setAmo(resultSet);

        return entity;
    }
}
