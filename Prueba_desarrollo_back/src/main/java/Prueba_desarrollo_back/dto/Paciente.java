package Prueba_desarrollo_back.dto;

import Prueba_desarrollo_back.util.UtilDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Data
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idpaciente;

    private String nombre;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaNapaciente;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaRegistro;


    private int fk_especie;

    private int fk_amo;


    @JsonIgnore
    public void setPaciente(ResultSet resultSet) throws SQLException {
        idpaciente = resultSet.getInt("idpaciente");
        nombre = resultSet.getString("nombre");
        fechaNapaciente = UtilDate.getLocalDate(resultSet.getDate("fechaNapaciente"));
        fechaRegistro = UtilDate.getLocalDate(resultSet.getDate("fechaRegistro"));
        fk_especie = resultSet.getInt("fk_especie");
        fk_amo = resultSet.getInt("fk_amo");
    }


}
