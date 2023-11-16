package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TarifarioEmbarcacionDTO implements Serializable {
    private TarifarioGeneralIdDTO id;
    private DiaSemanaDTO idDia;
    private EmbarcacionDTO idEmbarcacion;
    private ProveedorDTO idProveedor;
    private TipoServicioDTO idTipoServicio;
    private MonedaDTO idMoneda;
    private Number monto;
    private Boolean estado;
    private Boolean estadoReg;
}
