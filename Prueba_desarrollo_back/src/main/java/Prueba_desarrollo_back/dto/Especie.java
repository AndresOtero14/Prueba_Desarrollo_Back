package Prueba_desarrollo_back.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class Especie implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idespecie;

    private String nombre;

    private int fk_raza;

    @JsonIgnore
    public void setEspecie(ResultSet resultSet) throws SQLException{
        idespecie = resultSet.getInt("idespecie");
        nombre = resultSet.getString("nombre");
        fk_raza = resultSet.getInt("fk_raza");
    }
}
