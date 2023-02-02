package Prueba_desarrollo_back.config.controller;

import Prueba_desarrollo_back.config.controller.errores.ApplicationCustomException;
import Prueba_desarrollo_back.dto.Amo;
import Prueba_desarrollo_back.service.AmoService;
import Prueba_desarrollo_back.util.MessagesConstants;
import Prueba_desarrollo_back.util.ResponseMessage;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AmoController {

    private org.slf4j.Logger log = LoggerFactory.getLogger(AmoController.class);

    private static  final String ENITY_NAME ="Amo";

    private final AmoService amoService;


    public AmoController(AmoService amoService) {
        this.amoService = amoService;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/amo/all")
    public ResponseEntity<ResponseMessage<List<Amo>>> getAllAmo(){
        log.debug("REST request to get all Amo");
        return ResponseEntity.ok(new ResponseMessage<>(0, null, amoService.findAll()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/amo/save")
    public ResponseEntity<ResponseMessage<Amo>>  createAmo(@RequestBody Amo amo) throws ApplicationCustomException{
        log.debug("REST request to save Amo : {}", amo);
        Amo amoFind = amoService.findOne(amo.getIdamo());

        if(amoFind != null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENITY_NAME));
        }
        Amo result = amoService.save(amo);
        return ResponseEntity.ok(new ResponseMessage<>(0,null,result));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/amo/update")
    public ResponseEntity<ResponseMessage<Amo>> updateAmo(@RequestBody  Amo amo) throws ApplicationCustomException {
        log.debug("REST request to update Amo : {}", amo);

        if (amo.getIdamo() == 0){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE,String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENITY_NAME));
        }
        Amo result = amoService.update(amo);
        return ResponseEntity.ok(new ResponseMessage<>(0,null, result));
    }

    @DeleteMapping("/amo/{idamo}")
    public ResponseEntity<ResponseMessage<Amo>>  delete (@PathVariable Long idamo){
        log.debug("REST request to delete data : {}", idamo);
        amoService.delete(idamo);
        return ResponseEntity.ok(new ResponseMessage<>(0,null, null));
    }


}
