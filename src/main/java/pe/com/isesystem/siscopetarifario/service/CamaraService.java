package pe.com.isesystem.siscopetarifario.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.isesystem.siscopetarifario.dto.CamaraDTO;
import pe.com.isesystem.siscopetarifario.model.Camara;
import pe.com.isesystem.siscopetarifario.repository.CamaraRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CamaraService {
    CamaraRepository camaraRepository;
    ModelMapper modelMapper;
    public CamaraService(CamaraRepository camaraRepository, ModelMapper modelMapper){
        this.camaraRepository = camaraRepository;
        this.modelMapper = modelMapper;
    }

    public List<CamaraDTO> getAllCamara(){
        List<Camara> lista = this.camaraRepository.findAll();
        List<CamaraDTO> listaDTO = lista.stream().map((element) -> modelMapper.map(element, CamaraDTO.class)).toList();
        return  listaDTO;
    }
}
