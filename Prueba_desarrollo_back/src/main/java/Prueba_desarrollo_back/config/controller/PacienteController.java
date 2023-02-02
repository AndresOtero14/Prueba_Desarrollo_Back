package Prueba_desarrollo_back.config.controller;

import Prueba_desarrollo_back.config.controller.errores.ApplicationCustomException;
import Prueba_desarrollo_back.dto.Paciente;
import Prueba_desarrollo_back.service.PacienteService;
import Prueba_desarrollo_back.util.MessagesConstants;
import Prueba_desarrollo_back.util.ResponseMessage;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class PacienteController {

    private org.slf4j.Logger log = LoggerFactory.getLogger(PacienteController.class);

    private static final String ENITY_NAME = "Paciente";


    public final PacienteService pacienteService;


    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/paciente/all")
    public ResponseEntity<ResponseMessage<List<Paciente>>> getAllAmo() {
        log.debug("REST request to get all paciente");
        return ResponseEntity.ok(new ResponseMessage<>(0, null, pacienteService.findAll()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/paciente/save")
    public ResponseEntity<ResponseMessage<Paciente>> createPaciente(@RequestBody Paciente paciente) throws ApplicationCustomException{
        log.debug("REST request to save Paciente : {}", paciente);
        Paciente pacieFind = pacienteService.findOne(paciente.getIdpaciente());

        if(pacieFind != null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENITY_NAME));
        }
        Paciente result = pacienteService.save(paciente);
        return ResponseEntity.ok( new ResponseMessage<>(0,null,result));
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/paciente/update")
    public ResponseEntity<ResponseMessage<Paciente>> updatePaciente(@RequestBody Paciente paciente) throws ApplicationCustomException{
        log.debug("REST  request to update Paciente : {}", paciente);

        if (paciente.getIdpaciente() == 0){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE,String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENITY_NAME));
        }
        Paciente result  = pacienteService.update(paciente);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, result));
    }


    @DeleteMapping("/paciente/delete/{idpaciente}")
    public ResponseEntity<ResponseMessage<Paciente>> delete(@PathVariable int idpaciente){
        log.debug("REST request to delete data :  {}",idpaciente);
        pacienteService.delete(idpaciente);
        return  ResponseEntity.ok(new ResponseMessage<>(0,null,null));
    }

}
