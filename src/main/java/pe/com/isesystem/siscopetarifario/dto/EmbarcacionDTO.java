package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmbarcacionDTO implements Serializable {
    private Long idEmbarcacion;
    private Long idProveedor;
    private String nombreEmbarcacion;
    private String numMatricula;
    private Number tonelaje;
    private Boolean estado;
    private Boolean estadoReg;
}
