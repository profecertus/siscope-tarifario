package pe.com.isesystem.siscopetarifario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.isesystem.siscopetarifario.dto.SemanaDTO;
import pe.com.isesystem.siscopetarifario.service.SemanaService;

import java.util.List;

@RestController
@RequestMapping("/semana/v1")
public class SemanaController {
    @Autowired
    SemanaService semanaService;

    @GetMapping("/ultimaSemanaGrabada/")
    public ResponseEntity<SemanaDTO> getLastWeekSave(){
        return new ResponseEntity<>(semanaService.ultimaSemanaActiva(), HttpStatus.OK);
    }

    @GetMapping("/semanaPorFecha/{fecha}")
    public ResponseEntity<SemanaDTO> getWeekforDate(@PathVariable String fecha ){
        return new ResponseEntity<>(semanaService.semanaDeLaFecha(fecha), HttpStatus.OK);
    }

    @GetMapping("/semanaActual")
    public ResponseEntity<SemanaDTO> getSemanaActual(){
        return new ResponseEntity<>( semanaService.getSemanaActual(), HttpStatus.OK );
    }

    @GetMapping("/getAllSemana/{pag}/{tot}")
    public Page<SemanaDTO> getAllSemana(@PathVariable int pag, @PathVariable int tot){
        return semanaService.getAllSemana(pag, tot);
    }

}
