package pe.com.isesystem.siscopetarifario.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.isesystem.siscopetarifario.model.TarifarioGeneral;
import pe.com.isesystem.siscopetarifario.repository.TarifarioGeneralRepository;
import pe.com.isesystem.siscopetarifario.dto.TarifarioGeneralDTO;

import java.util.List;

@Service
public class TarifarioGeneralService {
    ModelMapper modelMapper;
    TarifarioGeneralRepository tarifarioGeneralRepository;

    public TarifarioGeneralService(ModelMapper modelMapper, TarifarioGeneralRepository tarifarioGeneralRepository){
        this.modelMapper = modelMapper;
        this.tarifarioGeneralRepository = tarifarioGeneralRepository;
    }

    public List<TarifarioGeneralDTO> getAllTarifarioGeneral(Long idAnio){
        List<TarifarioGeneral> lista = this.tarifarioGeneralRepository.findAllById_IdAnio(idAnio);
        return lista.stream().map((element) -> modelMapper.map(element, TarifarioGeneralDTO.class)).toList();
    }
}
