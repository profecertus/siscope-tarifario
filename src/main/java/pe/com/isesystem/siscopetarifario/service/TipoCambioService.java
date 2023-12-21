package pe.com.isesystem.siscopetarifario.service;

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

    public TipoCambioDTO findTipoCambioxFecha(Long idDia){
        //Solo recupero para el tipo 2, dolar.
        TipoCambioIdDTO tipoCambioIdDTO = new TipoCambioIdDTO(2, idDia);
        TipoCambioDTO tipoCambioDTO = new TipoCambioDTO();
        TipoCambioId tipoCambioId = modelMapper.map(tipoCambioIdDTO, TipoCambioId.class);
        Optional<TipoCambio> tipoCambio = this.tipoCambioRepository.findById(tipoCambioId);
        if (tipoCambio.isPresent())
            tipoCambioDTO = modelMapper.map(tipoCambio.get(), TipoCambioDTO.class);
        return  tipoCambioDTO;
    }

    public TipoCambioDTO grabarTipoCambio(TipoCambioDTO tipoCambioDTO){
        TipoCambio tipoCambio = modelMapper.map(tipoCambioDTO, TipoCambio.class);
        TipoCambioDTO tipoCambioDTO1 = modelMapper.map(this.tipoCambioRepository.save(tipoCambio), TipoCambioDTO.class);
        return tipoCambioDTO1;
    }

    public List<TipoCambioDTO> getAll(){
        return this.tipoCambioRepository.findAll().
                stream().map((element) -> modelMapper.map(element, TipoCambioDTO.class)).
                collect(Collectors.toList());
    }

}
