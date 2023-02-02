package Prueba_desarrollo_back.config.controller;

import Prueba_desarrollo_back.config.controller.errores.ApplicationCustomException;
import Prueba_desarrollo_back.dto.Raza;
import Prueba_desarrollo_back.service.RazaService;
import Prueba_desarrollo_back.util.MessagesConstants;
import Prueba_desarrollo_back.util.ResponseMessage;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class RazaController {

    private org.slf4j.Logger  log =  LoggerFactory.getLogger(RazaController.class);

    private static  final String ENITY_NAME = "Raza";

    private final RazaService razaService;

    public RazaController(RazaService razaService) {
        this.razaService = razaService;
    }

    @CrossOrigin(origins = "http://localhost:4200" )
    @GetMapping("/raza/all")
    public ResponseEntity<ResponseMessage<List<Raza>>> getAllRaza(){
        log.debug("Rest request to get all Raza");
        return  ResponseEntity.ok(new ResponseMessage<>(0,null, razaService.findAll()));
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @PostMapping("/raza/save")
    public ResponseEntity<ResponseMessage<Raza>> createRaza( @RequestBody Raza raza) throws ApplicationCustomException{
        log.debug("REST request to save Raza : {}", raza);
        Raza  raFind = razaService.findOne(raza.getIdraza());

        if(raFind != null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENITY_NAME));
        }
        Raza result  = razaService.save(raza);
        return  ResponseEntity.ok(new ResponseMessage<>(0, null, result));
    }


    @CrossOrigin(origins ="http://localhost:4200" )
    @PostMapping("/raza/update")
    public ResponseEntity<ResponseMessage<Raza>> updateRaza(@RequestBody Raza raza) throws ApplicationCustomException{
        log.debug("REST request to update Raza : {} ", raza);

        if (raza.getIdraza() == 0){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE,String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENITY_NAME));
        }
        Raza result = razaService.update(raza);
        return  ResponseEntity.ok(new ResponseMessage<>(0, null, result));
    }

    @DeleteMapping("/raza/delete/{idraza}")
    public ResponseEntity<ResponseMessage<Raza>>  delete(@PathVariable Long idraza){
        log.debug("REST request to delete data : {}", idraza);
        razaService.delete(idraza);
        return ResponseEntity.ok(new ResponseMessage<>(0,null,null));
    }

}
