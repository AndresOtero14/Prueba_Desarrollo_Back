package Prueba_desarrollo_back.dao;

import Prueba_desarrollo_back.dto.Raza;
import Prueba_desarrollo_back.mapper.RazaMapper;
import org.springframework.cache.CacheManager;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class RazaDao implements RazaDaoInterfas {

    private static final String INSERT ="INSERT INTO raza(idraza,nombre) VALUES (?,?)";
    private static final String UPDATE = "UPDATE raza set nombre=? WHERE idraza = ?";
    private static final String SELECT ="SELECT * FROM raza";
    private static final String SELECTBYID = SELECT + " WHERE idraza = ?";

    private static final String DELETE="DELETE FROM raza WHERE idraza = ?";


    JdbcTemplate jdbcTemplate;
    private CacheManager cacheManager;

    public RazaDao (DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource) ;
    }

    @Override
    public List<Raza> getAll() {
        return jdbcTemplate.query(SELECT, new RazaMapper());
    }

    @Override
    public Raza getById(int idraza) {

        try {

            return  jdbcTemplate.queryForObject(SELECTBYID, new RazaMapper(), idraza);
        }catch (EmptyResultDataAccessException ex){
            return null;
        }

    }

    @Override
    public Raza insert(Raza entity) {

        jdbcTemplate.update(INSERT,
                entity.getIdraza(),
                entity.getNombre());
        return entity;
    }

    @Override
    public Raza update(Raza entity) {
        jdbcTemplate.update(UPDATE,
                entity.getNombre(),
                entity.getIdraza());
        return entity;
    }

    @Override
    public Boolean delete(Long idraza) {
        return  jdbcTemplate.update(DELETE,idraza)>0;
    }
}
