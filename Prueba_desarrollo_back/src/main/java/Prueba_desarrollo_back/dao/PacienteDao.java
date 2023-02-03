package Prueba_desarrollo_back.dao;

import Prueba_desarrollo_back.dto.Paciente;
import Prueba_desarrollo_back.mapper.PacienteMapper;
import org.springframework.cache.CacheManager;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PacienteDao implements PacienteDaoInterfas {

    private static final String INSERT = "INSERT INTO paciente(idpaciente,nombre, fechaNapaciente, fechaRegistro, fk_especie, fk_amo) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE paciente set nombre=? , fechaNapaciente=?,fechaRegistro=?, fk_especie=?, fk_amo=?   WHERE idpaciente = ?";
    private static final String SELECT = "SELECT * FROM paciente";
    private static final String SELECTBYID = SELECT + " WHERE idpaciente = ?";

    private static final String DELETE = "DELETE FROM paciente WHERE idpaciente = ?";

    JdbcTemplate jdbcTemplate;
    private CacheManager cacheManager;

    public PacienteDao (DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Paciente> getAll() {
        return jdbcTemplate.query(SELECT,new PacienteMapper());
    }

    @Override
    public Paciente getById(int idpacinete) {

        try {
            return jdbcTemplate.queryForObject(SELECTBYID, new PacienteMapper(),idpacinete);
        }catch (EmptyResultDataAccessException ex){
            return null;
        }



    }

    @Override
    public Paciente insert(Paciente entity) {

        jdbcTemplate.update(INSERT,
                entity.getIdpaciente(),
                entity.getNombre(),
                entity.getFechaNapaciente(),
                entity.getFechaRegistro(),
                entity.getFk_especie(),
                entity.getFk_amo());


        return entity;
    }

    @Override
    public Paciente update(Paciente entity) {
        jdbcTemplate.update(UPDATE,
                entity.getNombre(),
                entity.getFechaNapaciente(),
                entity.getFechaRegistro(),
                entity.getFk_especie(),
                entity.getFk_amo(),
                entity.getIdpaciente());


        return entity;
    }

    @Override
    public Boolean delete(int idpacinete) {
        return jdbcTemplate.update(DELETE,idpacinete)>0;
    }
}