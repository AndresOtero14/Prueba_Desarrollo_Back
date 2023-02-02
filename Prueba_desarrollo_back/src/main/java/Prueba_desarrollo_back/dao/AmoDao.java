package Prueba_desarrollo_back.dao;

import Prueba_desarrollo_back.dto.Amo;
import Prueba_desarrollo_back.mapper.AmoMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class AmoDao implements AmoDaoInterfas{

    private static final String INSERT ="INSERT INTO amo(idamo,tipoid,nombre, telefono, ciudad, direccion) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE amo set tipoid=? , nombre=?,telefono=?, ciudad=?, direccion=?   WHERE idamo = ?";
    private static final String SELECT ="SELECT * FROM amo";
    private static final String SELECTBYID = SELECT + " WHERE idamo = ?";

    private static final String DELETE="DELETE FROM amo WHERE idamo = ?";


    JdbcTemplate jdbcTemplate;


    public AmoDao (DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Amo> getAll() {
        return jdbcTemplate.query(SELECT, new AmoMapper());
    }

    @Override
    public Amo getById(int idamo) {

        try {
            return jdbcTemplate.queryForObject(SELECTBYID, new AmoMapper(),idamo);
        }catch (EmptyResultDataAccessException ex){
            return null;
        }
        }


    @Override
    public Amo insert(Amo entity) {
        jdbcTemplate.update(INSERT,
                entity.getIdamo(),
                entity.getTipoid(),
                entity.getNombre(),
                entity.getTelefono(),
                entity.getCiudad(),
                entity.getDireccion());

        return entity;
    }

    @Override
    public Amo update(Amo entity) {
        jdbcTemplate.update(UPDATE,
                entity.getTipoid(),
                entity.getNombre(),
                entity.getTelefono(),
                entity.getCiudad(),
                entity.getDireccion(),
                entity.getIdamo());

        return entity;
    }

    @Override
    public Boolean delete(Long idamo) {
        return jdbcTemplate.update(DELETE, idamo)>0;
    }
}
