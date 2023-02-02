package Prueba_desarrollo_back.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class Amo implements Serializable {

    private static final long serialVersionUID = 1L;


    private int idamo;

    private String tipoid;

    private String nombre;

    private String telefono;

    private String ciudad;

    private String direccion;



    @JsonIgnore
    public void setAmo(ResultSet resultSet) throws SQLException{
        idamo= resultSet.getInt("idamo");
        tipoid=resultSet.getString("tipoid");
        nombre= resultSet.getString("nombre");
        telefono = resultSet.getString("telefono");
        ciudad = resultSet.getString("ciudad");
        direccion = resultSet.getString("direccion");


    }
}
