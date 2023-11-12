package pe.com.isesystem.siscopetarifario.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.isesystem.siscopetarifario.dto.SemanaDTO;
import pe.com.isesystem.siscopetarifario.dto.TarifarioGeneralDTO;
import pe.com.isesystem.siscopetarifario.service.TarifarioGeneralService;

import java.util.List;

@RestController
@RequestMapping("/tarifario/v1")
public class TarifarioGeneralController {

    @Autowired
    TarifarioGeneralService tarifarioGeneralService;

    @PostMapping("/getAllTarifario")
    public ResponseEntity<List<TarifarioGeneralDTO>> getAllTarifario(@RequestBody SemanaDTO fecha){
        return new ResponseEntity<>(this.tarifarioGeneralService.getAllTarifarioGeneral(fecha), HttpStatus.OK);
    }

    @PostMapping("/createWeek")
    public ResponseEntity<Integer> createWeek(@RequestBody SemanaDTO semana){
        int valor = this.tarifarioGeneralService.cargarProductos(semana);
        return  new ResponseEntity<>(valor, HttpStatus.OK);
    }

}