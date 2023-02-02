package Prueba_desarrollo_back.mapper;

import Prueba_desarrollo_back.dto.Paciente;
import Prueba_desarrollo_back.util.UtilDate;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteMapper implements RowMapper<Paciente> {

    @Override
    public Paciente mapRow(ResultSet resultSet, int i) throws SQLException{
        Paciente entity = new Paciente();
        entity.setIdpaciente(resultSet.getInt("idpaciente"));
        entity.setNombre(resultSet.getString("nombre"));
        entity.setFechaNapaciente(UtilDate.getLocalDate(resultSet.getDate("fechaNapaciente")));
        entity.setFechaNapaciente(UtilDate.getLocalDate(resultSet.getDate("fechaRegistro")));
        entity.setFk_especie(resultSet.getInt("fk_especie"));
        entity.setFk_amo(resultSet.getInt("fk_amo"));
        entity.setPaciente(resultSet);
        return  entity;
    }
}
