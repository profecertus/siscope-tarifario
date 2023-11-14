package pe.com.isesystem.siscopetarifario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.isesystem.siscopetarifario.dto.DiaSemanaDTO;
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
    public ResponseEntity<List<TarifarioGeneralDTO>> getAllTarifario(@RequestBody Long idDiaSemana){
        return new ResponseEntity<>(this.tarifarioGeneralService.getAllTarifarioGeneral(idDiaSemana), HttpStatus.OK);
    }

    @PostMapping("/createWeek")
    public ResponseEntity<Integer> createWeek(@RequestBody DiaSemanaDTO diaSemanaDTO){
        int valor = this.tarifarioGeneralService.cargarProductos(diaSemanaDTO);
        return  new ResponseEntity<>(valor, HttpStatus.OK);
    }

    @PostMapping("/saveTarifa")
    public  ResponseEntity<TarifarioGeneralDTO> saveTarifa(@RequestBody TarifarioGeneralDTO tarifarioGeneralDTO){
        return new ResponseEntity<>(tarifarioGeneralService.grabarTarifa(tarifarioGeneralDTO), HttpStatus.OK);
    }

}