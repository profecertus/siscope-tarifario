package pe.com.isesystem.siscopetarifario.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.isesystem.siscopetarifario.model.TarifarioEmbarcacion;
import pe.com.isesystem.siscopetarifario.model.TarifarioEmbarcacionId;
import pe.com.isesystem.siscopetarifario.model.TarifarioGeneral;
import pe.com.isesystem.siscopetarifario.repository.DiaSemanaRepository;
import pe.com.isesystem.siscopetarifario.repository.MonedaRepository;
import pe.com.isesystem.siscopetarifario.repository.TarifarioEmbarcacionRepository;
import pe.com.isesystem.siscopetarifario.repository.TarifarioGeneralRepository;
import pe.com.isesystem.siscopetarifario.dto.*;

import java.util.List;

@Service
public class TarifarioGeneralService {
    private final ModelMapper modelMapper;
    private final TarifarioGeneralRepository tarifarioGeneralRepository;
    private final TarifarioEmbarcacionRepository tarifarioEmbarcacionRepository;

    public TarifarioGeneralService(ModelMapper modelMapper, TarifarioGeneralRepository tarifarioGeneralRepository,
                                   TarifarioEmbarcacionRepository tarifarioEmbarcacionRepository) {
        this.modelMapper = modelMapper;
        this.tarifarioGeneralRepository = tarifarioGeneralRepository;
        this.tarifarioEmbarcacionRepository = tarifarioEmbarcacionRepository;
    }

    public List<TarifarioGeneralDTO> getAllTarifarioGeneral(Long idDiaSemana) {
        List<TarifarioGeneral> lista = this.tarifarioGeneralRepository.findAllById_IdDia( idDiaSemana );
        return lista.stream().map((element) -> modelMapper.map(element, TarifarioGeneralDTO.class)).toList();
    }

    public List<TarifarioEmbarcacionDTO> getAllTarifarioEmbarcacion(Long idDiaSemana) {
        //System.out.println(idDiaSemana);
        List<TarifarioEmbarcacion> lista = this.tarifarioEmbarcacionRepository.findAllById_IdDia( idDiaSemana );
        return lista.stream().map((element) -> modelMapper.map(element, TarifarioEmbarcacionDTO.class)).toList();
    }

    public int cargarProductos(DiaSemanaDTO diaSemanaDTO){
        return this.tarifarioGeneralRepository.createTarifas(diaSemanaDTO.getIdDia().toString() );
    }

    public TarifarioGeneralDTO grabarTarifa(TarifarioGeneralDTO tarifarioGeneralDTO){
        TarifarioGeneral tg = modelMapper.map(tarifarioGeneralDTO, TarifarioGeneral.class);
        TarifarioGeneral t = tarifarioGeneralRepository.save( tg );
        return modelMapper.map(t, TarifarioGeneralDTO.class);
    }

    public TarifarioEmbarcacionDTO grabarTarifaEmbarcacion(TarifarioEmbarcacionDTO tarifarioEmbarcacionDTO){
        TarifarioEmbarcacion te = modelMapper.map(tarifarioEmbarcacionDTO, TarifarioEmbarcacion.class);
        TarifarioEmbarcacion t = tarifarioEmbarcacionRepository.save( te );
        return modelMapper.map(t, TarifarioEmbarcacionDTO.class);
    }
}
