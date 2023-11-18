package pe.com.isesystem.siscopetarifario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.isesystem.siscopetarifario.dto.*;
import pe.com.isesystem.siscopetarifario.model.TarifarioPlanta;
import pe.com.isesystem.siscopetarifario.service.TarifarioGeneralService;

import java.util.List;

@RestController
@RequestMapping("/tarifario/v1")
public class TarifarioGeneralController {

    @Autowired
    TarifarioGeneralService tarifarioGeneralService;


    @GetMapping("/getAllTarifario/{idDiaSemana}")
    public ResponseEntity<Page<TarifarioGeneralDTO>> getAllTarifario(@PathVariable Long idDiaSemana){
        return new ResponseEntity<>(this.tarifarioGeneralService.getAllTarifarioGeneral(idDiaSemana), HttpStatus.OK);
    }

    @GetMapping("/getAllTarifarioEmbarcacion/{idDiaSemana}")
    public ResponseEntity<List<TarifarioEmbarcacionDTO>> getAllTarifarioEmbarcacion(@PathVariable Long idDiaSemana){
        return new ResponseEntity<>(this.tarifarioGeneralService.getAllTarifarioEmbarcacion(idDiaSemana), HttpStatus.OK);
    }

    @GetMapping("/getAllTarifarioPlanta/{idDiaSemana}")
    public ResponseEntity<List<TarifarioPlantaDTO>> getAllTarifarioPlanta(@PathVariable Long idDiaSemana){
        return new ResponseEntity<>(this.tarifarioGeneralService.getAllTarifarioPlanta(idDiaSemana), HttpStatus.OK);
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


    @PostMapping("/saveTarifaEmbarcacion")
    public  ResponseEntity<TarifarioEmbarcacionDTO> saveTarifaEmbarcacion(@RequestBody TarifarioEmbarcacionDTO tarifarioEmbarcacionDTO){
        return new ResponseEntity<>(tarifarioGeneralService.grabarTarifaEmbarcacion(tarifarioEmbarcacionDTO), HttpStatus.OK);
    }

    @PostMapping("/saveTarifaPlanta")
    public  ResponseEntity<TarifarioPlantaDTO> saveTarifaPlanta(@RequestBody TarifarioPlantaDTO tarifarioPlantaDTO){
        return new ResponseEntity<>(tarifarioGeneralService.grabarTarifaPlanta(tarifarioPlantaDTO), HttpStatus.OK);
    }

}