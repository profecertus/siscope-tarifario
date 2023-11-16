package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TarifarioEmbarcacionIdDTO implements Serializable {
    private Long idDia;
    private Long idEmbarcacion;
    private Long idProveedor;
    private Long idTipoServicio;
}
