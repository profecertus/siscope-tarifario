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

    public List<TarifarioGeneralDTO> getAllTarifarioGeneral(Long idAnio) {
        List<TarifarioGeneral> lista = this.tarifarioGeneralRepository.findAllById_IdAnio(idAnio);
        return lista.stream().map((element) -> modelMapper.map(element, TarifarioGeneralDTO.class)).toList();
    }

    public int cargarProductos(String fecha){
        //Validar si existe la semana para esta fecha en particular
        SemanaDTO s = this.semanaService.semanaDeLaFecha(fecha);
        //Si la semana no existe lo creo
        if (s.getId() == null){
            s = this.semanaService.saveSemana(fecha);
        }

        return this.tarifarioGeneralRepository.createNewWeek(s.getId().toString());
    }
}
