package pe.com.isesystem.siscopetarifario.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.com.isesystem.siscopetarifario.dto.TipoCambioDTO;
import pe.com.isesystem.siscopetarifario.dto.TipoCambioIdDTO;
import pe.com.isesystem.siscopetarifario.model.TipoCambio;
import pe.com.isesystem.siscopetarifario.model.TipoCambioId;
import pe.com.isesystem.siscopetarifario.repository.TipoCambioRepository;

import javax.sound.midi.MidiDevice;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoCambioService {
    private final TipoCambioRepository tipoCambioRepository;
    private final ModelMapper modelMapper;

    public TipoCambioService(TipoCambioRepository tipoCambioRepository, ModelMapper modelMapper){
        this.tipoCambioRepository = tipoCambioRepository;
        this.modelMapper = modelMapper;
    }

    public BigDecimal getTipoCambioHoy(){
        return this.tipoCambioRepository.findTipoCambioHoy();
    }

    public BigDecimal findTipoCambioxFecha(Long idDia){
        return this.tipoCambioRepository.findByDia(idDia);
    }

    @Transactional
    public int actualizarTipoCambio(Long fechaInicio, Long fechaFin, BigDecimal monto){
        int total = this.tipoCambioRepository.actualizaRangoTC(fechaInicio, fechaFin, monto);
        return total;
    }
    @Transactional
    public int grabarTipoCambio(TipoCambioDTO tipoCambioDTO){
        int total = this.tipoCambioRepository.saveCustomized(tipoCambioDTO.getId().getIdMoneda(),
                tipoCambioDTO.getId().getIdDia(), tipoCambioDTO.getValorCambio());
        return total;
    }

    public List<TipoCambioDTO> getAll(){
        return this.tipoCambioRepository.findAllCustomized().
                stream().map((element) -> modelMapper.map(element, TipoCambioDTO.class)).
                collect(Collectors.toList());
    }

}
