package pe.com.isesystem.siscopetarifario.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TarifarioGeneralDTO implements Serializable{
    private TarifarioGeneralIdDTO id;
    private ProveedorDTO idProveedor;
    private TipoServicioDTO idTipoServicio;
    private MonedaDTO idMoneda;
    private BigDecimal monto;
    private Boolean estado;
    private Boolean estadoReg;
}