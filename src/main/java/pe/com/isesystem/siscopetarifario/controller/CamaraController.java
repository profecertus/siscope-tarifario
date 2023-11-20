package pe.com.isesystem.siscopetarifario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.isesystem.siscopetarifario.dto.CamaraDTO;
import pe.com.isesystem.siscopetarifario.service.CamaraService;

import java.util.List;

@RestController
@RequestMapping("/camara/v1")
public class CamaraController {
    @Autowired
    CamaraService camaraService;
    @GetMapping("/getAllCamara")
    public List<CamaraDTO> getAllCamara(){
        return this.camaraService.getAllCamara();
    }
}
