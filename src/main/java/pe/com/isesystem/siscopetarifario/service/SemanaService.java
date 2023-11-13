package pe.com.isesystem.siscopetarifario.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.isesystem.siscopetarifario.dto.SemanaDTO;
import pe.com.isesystem.siscopetarifario.model.Semana;
import pe.com.isesystem.siscopetarifario.repository.SemanaRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SemanaService {
    private final SemanaRepository semanaRepository;
    private final ModelMapper modelMapper;

    public SemanaService(SemanaRepository semanaRepository, ModelMapper modelMapper){
        this.semanaRepository = semanaRepository;
        this.modelMapper = modelMapper;
    }

    public Page<SemanaDTO> getAllSemana(int pag, int tot){
        final Pageable pageable = PageRequest.of(pag, tot );
        Page<Semana> p = semanaRepository.findAll(pageable);
        List<SemanaDTO> l = p.getContent().stream().map((element) -> modelMapper.map(element, SemanaDTO.class)).toList();
        return new PageImpl<>(l, p.getPageable(), p.getTotalElements());
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


    public SemanaDTO getSemanaActual(){
        SemanaDTO sDTO = new SemanaDTO();
        LocalDate localDate = LocalDate.now();
        //System.out.println(LocalDate.now());
        int anio = localDate.getYear();
        int numeroSemana = localDate.get(WeekFields.of(java.util.Locale.getDefault()).weekOfWeekBasedYear()) ;

        LocalDate primerDiaSemana = LocalDate.of(anio, 1, 1)
                .with(TemporalAdjusters.firstDayOfYear())
                .plusWeeks(numeroSemana )
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        LocalDate ultimoDiaSemana = primerDiaSemana.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        sDTO.setEstado(true);
        sDTO.setId((long) (anio * 100 + numeroSemana));
        sDTO.setTipoSemana("O");
        sDTO.setFechaInicio((long) (primerDiaSemana.getYear() * 10000 +
                primerDiaSemana.getMonthValue() * 100 +
                primerDiaSemana.getDayOfMonth()));
        sDTO.setFechaFin((long) (ultimoDiaSemana.getYear() * 10000 +
                ultimoDiaSemana.getMonthValue() * 100 +
                ultimoDiaSemana.getDayOfMonth()));
        Semana s = modelMapper.map(sDTO, Semana.class);
        Semana sResp = this.semanaRepository.save(s);
        return modelMapper.map(sResp, SemanaDTO.class);
    }

}
