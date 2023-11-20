package pe.com.isesystem.siscopetarifario.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.isesystem.siscopetarifario.model.*;
import pe.com.isesystem.siscopetarifario.repository.*;
import pe.com.isesystem.siscopetarifario.dto.*;

import java.util.List;

@Service
public class TarifarioGeneralService {
    private final ModelMapper modelMapper;
    private final TarifarioGeneralRepository tarifarioGeneralRepository;
    private final TarifarioEmbarcacionRepository tarifarioEmbarcacionRepository;
    private final TarifarioPlantaRepository tarifarioPlantaRepository;
    private final TarifarioCamaraRepository tarifarioCamaraRepository;
    public TarifarioGeneralService(ModelMapper modelMapper, TarifarioGeneralRepository tarifarioGeneralRepository,
                                   TarifarioEmbarcacionRepository tarifarioEmbarcacionRepository,
                                   TarifarioPlantaRepository tarifarioPlantaRepository,
                                   TarifarioCamaraRepository tarifarioCamaraRepository) {
        this.modelMapper = modelMapper;
        this.tarifarioGeneralRepository = tarifarioGeneralRepository;
        this.tarifarioEmbarcacionRepository = tarifarioEmbarcacionRepository;
        this.tarifarioPlantaRepository = tarifarioPlantaRepository;
        this.tarifarioCamaraRepository = tarifarioCamaraRepository;
    }

    public Page<TarifarioGeneralDTO> getAllTarifarioGeneral(Long idDiaSemana, int numpag, int totpag) {
        Pageable pageable = PageRequest.of(numpag, totpag);
        Page<TarifarioGeneral> lista = this.tarifarioGeneralRepository.findAllById_IdDia( idDiaSemana, pageable );

        Page<TarifarioGeneralDTO> listaDto = new PageImpl<>(
                lista.stream().map((element) -> modelMapper.map(element, TarifarioGeneralDTO.class)).toList(),
                lista.getPageable(),
                lista.getTotalElements());
        return listaDto;
    }

    public List<TarifarioEmbarcacionDTO> getAllTarifarioEmbarcacion(Long idDiaSemana) {
        List<TarifarioEmbarcacion> lista = this.tarifarioEmbarcacionRepository.findAllById_IdDia( idDiaSemana );
        return lista.stream().map((element) -> modelMapper.map(element, TarifarioEmbarcacionDTO.class)).toList();
    }

    public List<TarifarioPlantaDTO> getAllTarifarioPlanta(Long idDiaSemana) {
        List<TarifarioPlanta> lista = this.tarifarioPlantaRepository.findAllById_IdDia( idDiaSemana );
        return lista.stream().map((element) -> modelMapper.map(element, TarifarioPlantaDTO.class)).toList();
    }

    public List<TarifarioCamaraDTO> getAllTarifarioCamara(Long idDiaSemana) {
        List<TarifarioCamara> lista = this.tarifarioCamaraRepository.findAllById_IdDia( idDiaSemana );
        return lista.stream().map((element) -> modelMapper.map(element, TarifarioCamaraDTO.class)).toList();
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
        TarifarioEmbarcacion te = this.modelMapper.map(tarifarioEmbarcacionDTO, TarifarioEmbarcacion.class);
        TarifarioEmbarcacion t = this.tarifarioEmbarcacionRepository.save( te );
        return this.modelMapper.map(t, TarifarioEmbarcacionDTO.class);
    }

    public TarifarioCamaraDTO grabarTarifaCamara(TarifarioCamaraDTO tarifarioCamaraDTO){
        TarifarioCamara te = this.modelMapper.map(tarifarioCamaraDTO, TarifarioCamara.class);
        TarifarioCamara t = this.tarifarioCamaraRepository.save( te );
        return this.modelMapper.map(t, TarifarioCamaraDTO.class);
    }

    public TarifarioPlantaDTO grabarTarifaPlanta(TarifarioPlantaDTO tarifarioPlantaDTO){
        TarifarioPlanta tp = this.modelMapper.map(tarifarioPlantaDTO, TarifarioPlanta.class);
        TarifarioPlanta t = this.tarifarioPlantaRepository.save(tp);
        return modelMapper.map(t, TarifarioPlantaDTO.class);
    }

}
