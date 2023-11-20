package pe.com.isesystem.siscopetarifario.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.isesystem.siscopetarifario.dto.UbigeoDTO;
import pe.com.isesystem.siscopetarifario.model.Ubigeo;
import pe.com.isesystem.siscopetarifario.repository.UbigeoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UbigeoService {
    UbigeoRepository ubigeoRepository;
    private final ModelMapper modelMapper;

    public UbigeoService(UbigeoRepository ubigeoRepository,
                         ModelMapper modelMapper){
        this.ubigeoRepository = ubigeoRepository;
        this.modelMapper = modelMapper;
    }
    public List<UbigeoDTO> getAllUbigeo(Boolean estado){
        List<Ubigeo> lista = this.ubigeoRepository.findAll();
        List<UbigeoDTO> listaDTO = lista.stream().map((element) -> modelMapper.map(element, UbigeoDTO.class)).toList();
        return  listaDTO;
    }
}
