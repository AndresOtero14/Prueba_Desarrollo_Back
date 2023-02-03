package Prueba_desarrollo_back.dao;


import Prueba_desarrollo_back.dto.Especie;
import Prueba_desarrollo_back.mapper.EspecieMapper;
import org.springframework.cache.CacheManager;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class EspecieDao implements EspecieDaoInterfas {
    private static final String INSERT ="INSERT INTO especie(idespecie,nombre, fk_raza) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE especie set nombre=? , fk_raza=? WHERE idespecie = ?";
    private static final String SELECT ="SELECT * FROM especie";
    private static final String SELECTBYID = SELECT + " WHERE idespecie = ?";

    private static final String DELETE="DELETE FROM especie WHERE idespecie = ?";


    JdbcTemplate jdbcTemplate;
    private CacheManager cacheManager;


    public EspecieDao (DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource) ;
    }

    @Override
    public List<Especie> getAll() {
        return jdbcTemplate.query(SELECT,new EspecieMapper());
    }

    @Override
    public Especie getById(int idespecie) {
        try {
            return  jdbcTemplate.queryForObject(SELECTBYID, new EspecieMapper(),idespecie);
        }catch (EmptyResultDataAccessException ex){
            return null;
        }


    }

    @Override
    public Especie insert(Especie entity) {
        jdbcTemplate.update(INSERT,
                entity.getIdespecie(),
                entity.getNombre(),
                entity.getFk_raza());

        return entity;
    }

    @Override
    public Especie update(Especie entity) {
        jdbcTemplate.update(UPDATE,
                entity.getNombre(),
                entity.getFk_raza(),
                entity.getIdespecie());

        return entity;
    }

    @Override
    public Boolean delete(Long idespecie) {
        return jdbcTemplate.update(DELETE, idespecie)>0;
    }
}

