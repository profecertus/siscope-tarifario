package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class TarifarioCamaraDTO implements Serializable {
    private TarifarioCamaraIdDTO id;
    private PlantaDTO idPlanta;
    private CamaraDTO placa;
    private DiaSemanaDTO idDia;
    private MonedaDTO idMoneda;
    private Number monto;
    private Boolean estado;
    private Boolean estadoReg;
}
