package Prueba_desarrollo_back.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class Raza implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idraza;

    private String nombre;


    @JsonIgnore
    public void setraza(ResultSet resultSet) throws SQLException{
        idraza= resultSet.getInt("idraza");
        nombre = resultSet.getString("nombre");
    }

}
