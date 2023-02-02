package Prueba_desarrollo_back.config.controller;

import Prueba_desarrollo_back.config.controller.errores.ApplicationCustomException;
import Prueba_desarrollo_back.dto.Especie;
import Prueba_desarrollo_back.service.EspecieService;
import Prueba_desarrollo_back.util.MessagesConstants;
import Prueba_desarrollo_back.util.ResponseMessage;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EspecieController {



    private org.slf4j.Logger log = LoggerFactory.getLogger(EspecieController.class);


    private static  final String ENITY_NAME ="Especie";

    private final EspecieService especieService;


    public EspecieController(EspecieService especieService) {
        this.especieService = especieService;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/especie/all")
    public ResponseEntity<ResponseMessage<List<Especie>>> getAllEspecie(){
       log.debug("Rest request to get all Especie");
       return  ResponseEntity.ok(new ResponseMessage<>(0,null, especieService.findAll()));
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/especie/save")
    public ResponseEntity<ResponseMessage<Especie>> createEspecie( @RequestBody  Especie especie) throws ApplicationCustomException {
        log.debug("REST request to save Especie : {}", especie);
        Especie espFind = especieService.findOne(especie.getIdespecie());

        if (espFind != null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENITY_NAME));
        }
     Especie result = especieService.save(especie);
        return ResponseEntity.ok(new ResponseMessage<>(0, null,result));
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/especie/update")
    public ResponseEntity<ResponseMessage<Especie>> updateEspecie(@RequestBody Especie especie) throws ApplicationCustomException{
        log.debug("REST request to update Especie : {} ", especie);

        if (especie.getIdespecie() == 0){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE,String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENITY_NAME));
        }
        Especie result = especieService.update(especie);
        return  ResponseEntity.ok(new ResponseMessage<>(0, null,result));
    }

    @DeleteMapping("/especie/delete{idespecie}")
    public ResponseEntity<ResponseMessage<Especie>> delete(@PathVariable Long idespecie){
        log.debug("REST request to delete TraDataMaestra : {}", idespecie);
        especieService.delete(idespecie);
        return ResponseEntity.ok(new ResponseMessage<>(0,null, null));
    }

}
