package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;
import pe.com.isesystem.siscopetarifario.model.TarifarioPlantaId;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TarifarioPlantaDTO implements Serializable {
    private TarifarioPlantaIdDTO id;
    private DiaSemanaDTO idDia;
    private PlantaDTO idPlanta;
    private ProveedorDTO idProveedor;
    private TipoServicioDTO idTipoServicio;
    private MonedaDTO idMoneda;
    private Number monto;
    private Boolean estado;
    private Boolean estadoReg;
}
