package pe.com.isesystem.siscopetarifario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.isesystem.siscopetarifario.dto.*;
import pe.com.isesystem.siscopetarifario.service.TarifarioGeneralService;

import java.util.List;

@RestController
@RequestMapping("/tarifario/v1")
public class TarifarioGeneralController {

    @Autowired
    TarifarioGeneralService tarifarioGeneralService;


    @GetMapping("/getAllTarifario/{idDiaSemana}/{numpag}/{totpag}")
    public ResponseEntity<Page<TarifarioGeneralDTO>> getAllTarifario(@PathVariable Long idDiaSemana,
                                                                     @PathVariable int numpag,
                                                                     @PathVariable int totpag){
        return new ResponseEntity<>(this.tarifarioGeneralService.getAllTarifarioGeneral(idDiaSemana, numpag, totpag), HttpStatus.OK);
    }

    @GetMapping("/getAllTarifarioEmbarcacion/{idDiaSemana}")
    public ResponseEntity<List<TarifarioEmbarcacionDTO>> getAllTarifarioEmbarcacion(@PathVariable Long idDiaSemana){
        return new ResponseEntity<>(this.tarifarioGeneralService.getAllTarifarioEmbarcacion(idDiaSemana), HttpStatus.OK);
    }

    @GetMapping("/getTarifarioEmbarcacion/{idDiaSemana}/{idEmbarcacion}/{idTipoServicio}")
    public  ResponseEntity<Object> getTarifarioEmbarcacion(@PathVariable Long idDiaSemana,
                                                           @PathVariable Long idEmbarcacion,
                                                           @PathVariable Long idTipoServicio){
        Object e = this.tarifarioGeneralService.getTarifarioEmbarcacion(idDiaSemana,
                idEmbarcacion,
                idTipoServicio);
        if(e == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @GetMapping("/getTarifarioPlanta/{idDiaSemana}/{idPlanta}/{idTipoServicio}")
    public  ResponseEntity<Object> getTarifarioPlanta(@PathVariable Long idDiaSemana,
                                                           @PathVariable Long idPlanta,
                                                           @PathVariable Long idTipoServicio){
        Object e = this.tarifarioGeneralService.getTarifarioPlanta(idDiaSemana,
                idPlanta,
                idTipoServicio);
        if(e == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(e, HttpStatus.OK);
    }


    @GetMapping("/getAllTarifarioFlete/{idDiaSemana}")
    public ResponseEntity<List<TarifarioFleteDTO>> getAllTarifarioFlete(@PathVariable Long idDiaSemana){
        return new ResponseEntity<>(this.tarifarioGeneralService.getAllTarifarioFlete(idDiaSemana), HttpStatus.OK);
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

    @PostMapping("/saveTarifaFlete")
    public  ResponseEntity<TarifarioFleteDTO> saveTarifaCamara(@RequestBody TarifarioFleteDTO tarifarioFleteDTO){
        return new ResponseEntity<>(tarifarioGeneralService.grabarTarifaFlete(tarifarioFleteDTO), HttpStatus.OK);
    }

    @PostMapping("/saveTarifaEmbarcacion")
    public  ResponseEntity<TarifarioEmbarcacionDTO> saveTarifaEmbarcacion(@RequestBody TarifarioEmbarcacionDTO tarifarioEmbarcacionDTO){
        return new ResponseEntity<>(tarifarioGeneralService.grabarTarifaEmbarcacion(tarifarioEmbarcacionDTO), HttpStatus.OK);
    }

    @PostMapping("/saveTarifaPlanta")
    public  ResponseEntity<TarifarioPlantaDTO> saveTarifaPlanta(@RequestBody TarifarioPlantaDTO tarifarioPlantaDTO){
        return new ResponseEntity<>(tarifarioGeneralService.grabarTarifaPlanta(tarifarioPlantaDTO), HttpStatus.OK);
    }

    @GetMapping("/getTarifaFlete/{ubigeo}/{dia}")
    public ResponseEntity<TarifarioFleteDTO> getTarifaDestinoxDia(@PathVariable String ubigeo, @PathVariable Long dia){
        return  new ResponseEntity<>(tarifarioGeneralService.getFletexDia(ubigeo, dia), HttpStatus.OK);
    }

}