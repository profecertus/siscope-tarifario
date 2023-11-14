package pe.com.isesystem.siscopetarifario.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.isesystem.siscopetarifario.model.TarifarioGeneral;
import pe.com.isesystem.siscopetarifario.repository.DiaSemanaRepository;
import pe.com.isesystem.siscopetarifario.repository.MonedaRepository;
import pe.com.isesystem.siscopetarifario.repository.TarifarioGeneralRepository;
import pe.com.isesystem.siscopetarifario.dto.*;

import java.util.List;

@Service
public class TarifarioGeneralService {
    private final ModelMapper modelMapper;
    private final TarifarioGeneralRepository tarifarioGeneralRepository;

    public TarifarioGeneralService(ModelMapper modelMapper, TarifarioGeneralRepository tarifarioGeneralRepository) {
        this.modelMapper = modelMapper;
        this.tarifarioGeneralRepository = tarifarioGeneralRepository;
    }

    public List<TarifarioGeneralDTO> getAllTarifarioGeneral(Long idDiaSemana) {
        List<TarifarioGeneral> lista = this.tarifarioGeneralRepository.findAllById_IdDia( idDiaSemana );
        return lista.stream().map((element) -> modelMapper.map(element, TarifarioGeneralDTO.class)).toList();
    }

    public int cargarProductos(DiaSemanaDTO diaSemanaDTO){
        return this.tarifarioGeneralRepository.createTarifas(diaSemanaDTO.getIdDia().toString() );
    }

    public TarifarioGeneralDTO grabarTarifa(TarifarioGeneralDTO tarifarioGeneralDTO){
        TarifarioGeneral tg = modelMapper.map(tarifarioGeneralDTO, TarifarioGeneral.class);
        TarifarioGeneral t = tarifarioGeneralRepository.save( tg );
        return modelMapper.map(t, TarifarioGeneralDTO.class);
    }
}
