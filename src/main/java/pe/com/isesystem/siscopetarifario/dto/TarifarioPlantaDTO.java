package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TarifarioPlantaDTO implements Serializable {
    private DiaSemanaDTO idDia;
    private PlantaDTO idPlanta;
    private ProveedorDTO idProveedor;
    private TipoServicioDTO idTipoServicio;
    private MonedaDTO idMoneda;
    private Number monto;
    private Boolean estado;
    private Boolean estadorReg;
}
