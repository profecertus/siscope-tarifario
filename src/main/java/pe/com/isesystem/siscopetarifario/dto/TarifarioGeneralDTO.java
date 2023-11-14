package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TarifarioGeneralDTO implements  Serializable{
    private TarifarioGeneralIdDTO id;
    private ProveedorDTO idProveedor;
    private TipoServicioDTO idTipoServicio;
    private DiaSemanaDTO idDia;
    private MonedaDTO idMoneda;
    private Number monto;
    private Boolean estado;
    private Boolean estadoReg;
}
