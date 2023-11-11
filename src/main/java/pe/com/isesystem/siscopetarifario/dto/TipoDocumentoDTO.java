package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoDocumentoDTO implements  Serializable {
    private Long idTipodoc;
    private String nombre;
    private String abreviatura;
    private Long longitud;
    private String tipo;
    private Boolean estado;
    private Boolean estadoReg;
}
