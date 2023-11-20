package pe.com.isesystem.siscopetarifario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.isesystem.siscopetarifario.dto.UbigeoDTO;
import pe.com.isesystem.siscopetarifario.service.UbigeoService;

import java.util.List;

@RestController
@RequestMapping("/ubigeo/v1")
public class UbigeoController {

    @Autowired
    UbigeoService ubigeoService;

    @GetMapping("/getAllUbigeo")
    public List<UbigeoDTO> getAllUbigeo(){
        return this.ubigeoService.getAllUbigeo(true);
    }
}
