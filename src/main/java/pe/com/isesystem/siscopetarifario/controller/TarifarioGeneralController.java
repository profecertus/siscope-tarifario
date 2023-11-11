package pe.com.isesystem.siscopetarifario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.isesystem.siscopetarifario.dto.TarifarioGeneralDTO;
import pe.com.isesystem.siscopetarifario.service.TarifarioGeneralService;

import java.util.List;

@RestController
@RequestMapping("/tarifario/v1")
public class TarifarioGeneralController {

    @Autowired
    TarifarioGeneralService tarifarioGeneralService;

    @GetMapping("/getAllTarifario")
    public ResponseEntity<List<TarifarioGeneralDTO>> getAllTarifario(){
        return new ResponseEntity<>(this.tarifarioGeneralService.getAllTarifarioGeneral(202345L), HttpStatus.OK);

    }
}
