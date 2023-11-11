package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoServicioDTO implements Serializable {
    private Long idTipoServicio;
    private String nombre;
    private UnidadMedidaDTO idUm;
    private Boolean estado;
    private Boolean estadoReg;

}
