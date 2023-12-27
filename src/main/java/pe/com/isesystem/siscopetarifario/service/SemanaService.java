package pe.com.isesystem.siscopetarifario.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.isesystem.siscopetarifario.dto.DiaSemanaDTO;
import pe.com.isesystem.siscopetarifario.dto.SemanaDTO;
import pe.com.isesystem.siscopetarifario.model.DiaSemana;
import pe.com.isesystem.siscopetarifario.model.Semana;
import pe.com.isesystem.siscopetarifario.repository.DiaSemanaRepository;
import pe.com.isesystem.siscopetarifario.repository.SemanaRepository;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SemanaService {
    private final SemanaRepository semanaRepository;
    private final ModelMapper modelMapper;
    private final DiaSemanaRepository diaSemanaRepository;

    public SemanaService(SemanaRepository semanaRepository, ModelMapper modelMapper,
                         DiaSemanaRepository diaSemanaRepository){
        this.semanaRepository = semanaRepository;
        this.modelMapper = modelMapper;
        this.diaSemanaRepository = diaSemanaRepository;
    }

    public Page<SemanaDTO> getAllSemana(int pag, int tot){
        final Pageable pageable = PageRequest.of(pag, tot );
        Page<Semana> p = semanaRepository.findAll(pageable);
        List<SemanaDTO> l = p.getContent().stream().map((element) -> modelMapper.map(element, SemanaDTO.class)).toList();
        return new PageImpl<>(l, p.getPageable(), p.getTotalElements());
    }

    public Date getFechaActual(){
        return semanaRepository.getAhora();
    }

    public Long getFecha(){
        return semanaRepository.getFecha();
    }

    public DiaSemanaDTO getDiaSemana(Long idDiaSemana){
        Optional<DiaSemana> diaSemana = this.diaSemanaRepository.findById(idDiaSemana);
        if (diaSemana.isPresent())
            return modelMapper.map(diaSemana, DiaSemanaDTO.class);
        else
            return new DiaSemanaDTO();
    }


    public SemanaDTO ultimaSemanaActiva(){
        Optional<Semana> s = this.semanaRepository.getLastWeekSave();
        return modelMapper.map(s.get(), SemanaDTO.class);
    }

    public SemanaDTO semanaDeLaFecha(String fecha){
        Optional<Semana> s = this.semanaRepository.getWeek(fecha);
        if (s.isPresent())
            return modelMapper.map(s.get(),SemanaDTO.class);
        else
            return new SemanaDTO();
    }

    public SemanaDTO buscaSemana(Long idSemana){
        Optional<Semana> s = this.semanaRepository.findById(idSemana);
        if (s.isPresent()){
            return modelMapper.map(s.get(), SemanaDTO.class);
        }
        return new SemanaDTO();
    }
    public SemanaDTO saveSemana(SemanaDTO semana){
        Semana s = modelMapper.map(semana, Semana.class);
        Semana sResp = this.semanaRepository.save(s);
        return modelMapper.map(sResp, SemanaDTO.class);
    }


    public DiaSemanaDTO getSemanaActual(){
        Optional<DiaSemana> ds =  diaSemanaRepository.findById( this.getFecha() );
        if(ds.isPresent())
            return this.modelMapper.map(ds.get(), DiaSemanaDTO.class);
        else
            return new DiaSemanaDTO();
    }

    public List<Object> getDiasxSemana(Long semana){
        List<Object> dias = diaSemanaRepository.getAllDaysFromWeek(semana);
        return dias;

    }
}
