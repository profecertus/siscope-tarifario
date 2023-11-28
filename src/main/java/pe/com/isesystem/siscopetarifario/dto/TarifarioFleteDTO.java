package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;
import pe.com.isesystem.siscopetarifario.model.DiaSemana;

import java.io.Serializable;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TarifarioFleteDTO implements Serializable {
    private TarifarioGeneralIdDTO id;
    private DiaSemanaDTO idDia;
    private Long idMoneda;
    private Number monto;
    private Boolean estado;
    private Boolean estadoReg;
}
