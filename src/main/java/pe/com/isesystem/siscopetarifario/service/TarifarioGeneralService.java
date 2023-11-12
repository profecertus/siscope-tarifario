package pe.com.isesystem.siscopetarifario.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.isesystem.siscopetarifario.model.TarifarioGeneral;
import pe.com.isesystem.siscopetarifario.repository.TarifarioGeneralRepository;
import pe.com.isesystem.siscopetarifario.dto.*;

import java.util.List;

@Service
public class TarifarioGeneralService {
    private final ModelMapper modelMapper;
    private final TarifarioGeneralRepository tarifarioGeneralRepository;
    private final SemanaService semanaService;

    public TarifarioGeneralService(ModelMapper modelMapper, TarifarioGeneralRepository tarifarioGeneralRepository,
                                   SemanaService semanaService) {
        this.modelMapper = modelMapper;
        this.tarifarioGeneralRepository = tarifarioGeneralRepository;
        this.semanaService = semanaService;
    }

    public List<TarifarioGeneralDTO> getAllTarifarioGeneral(SemanaDTO semana) {
        List<TarifarioGeneral> lista = this.tarifarioGeneralRepository.findAllById_IdAnio(semana.getId());
        return lista.stream().map((element) -> modelMapper.map(element, TarifarioGeneralDTO.class)).toList();
    }

    public int cargarProductos(SemanaDTO semana){
        //creo la semana si no existe
        SemanaDTO semanaDTO = semanaService.buscaSemana(semana.getId());
        if (semanaDTO.getId() == null)
            semanaService.saveSemana(semana);

        return this.tarifarioGeneralRepository.createNewWeek(semana.getId().toString());
    }
}
