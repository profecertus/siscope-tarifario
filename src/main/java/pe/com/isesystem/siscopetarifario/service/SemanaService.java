package pe.com.isesystem.siscopetarifario.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.isesystem.siscopetarifario.dto.SemanaDTO;
import pe.com.isesystem.siscopetarifario.model.Semana;
import pe.com.isesystem.siscopetarifario.repository.SemanaRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Optional;

@Service
public class SemanaService {
    private final SemanaRepository semanaRepository;
    private final ModelMapper modelMapper;

    public SemanaService(SemanaRepository semanaRepository, ModelMapper modelMapper){
        this.semanaRepository = semanaRepository;
        this.modelMapper = modelMapper;
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

    public SemanaDTO saveSemana(String fecha){
        LocalDate localDate;
        SemanaDTO sDTO = new SemanaDTO();
        //Creo una fecha a partir del numero
        if(fecha.trim().length() != 8)
            return sDTO;
        else{
            localDate = LocalDate.of(Integer.parseInt(fecha.substring(0,4)),
                    Integer.parseInt(fecha.substring(4,6)),
                    Integer.parseInt(fecha.substring(6)));
        }
        int anio = Integer.parseInt(fecha.substring(0,4));
        int numeroSemana = localDate.get(WeekFields.of(java.util.Locale.getDefault()).weekOfWeekBasedYear());

        LocalDate primerDiaSemana = LocalDate.of(anio, 1, 1)  // Puedes usar cualquier fecha del año
                .with(TemporalAdjusters.firstDayOfYear())
                .plusWeeks(numeroSemana )
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        // Obtener la fecha del último día (domingo) de la semana
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
