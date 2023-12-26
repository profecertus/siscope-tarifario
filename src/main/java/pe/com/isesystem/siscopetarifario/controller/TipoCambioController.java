package pe.com.isesystem.siscopetarifario.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.isesystem.siscopetarifario.dto.TipoCambioDTO;
import pe.com.isesystem.siscopetarifario.service.TipoCambioService;

@RestController
@RequestMapping("/tipocambio/v1")
public class TipoCambioController {

    @Autowired
    TipoCambioService tipoCambioService;

    @GetMapping("/getAllTipoCambio")
    public ResponseEntity<List<TipoCambioDTO>> getAll(){
        return new ResponseEntity<>(tipoCambioService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getCambioHoy")
    public ResponseEntity<BigDecimal> getCambioHoy(){
        return new ResponseEntity<>(tipoCambioService.getTipoCambioHoy(), HttpStatus.OK);
    }

    @GetMapping("/getCambioDia/{dia}")
    public ResponseEntity<BigDecimal> getCambioDia(@PathVariable Long dia){
        return new ResponseEntity<>(this.tipoCambioService.findTipoCambioxFecha(dia), HttpStatus.OK);
    }

    @PostMapping("/grabarTipoCambio")
    public ResponseEntity<Integer> saveTipoCambio(@RequestBody TipoCambioDTO tipoCambioDTO){
        return new ResponseEntity<>(this.tipoCambioService.grabarTipoCambio(tipoCambioDTO), HttpStatus.OK);
    }

    @PostMapping("/actualizarTipoCambio/{fi}/{ff}/{monto}")
    public ResponseEntity<Integer> actualizarTipoCambio(@PathVariable Long fi, @PathVariable Long ff, @PathVariable BigDecimal monto){
        return new ResponseEntity<>(this.tipoCambioService.actualizarTipoCambio(fi, ff, monto), HttpStatus.OK);
    }

}
