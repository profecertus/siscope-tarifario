package pe.com.isesystem.siscopetarifario.dto;
import java.io.Serializable;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TarifarioGeneralIdDTO implements  Serializable{
    private Long idProveedor;
    private Long idTipoServicio;
    private Long idDia;
    private Long idEmbarcacion;
}
