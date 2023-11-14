package pe.com.isesystem.siscopetarifario.dto;
import java.io.Serializable;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TarifarioGeneralIdDTO implements  Serializable{
    private Integer idProveedor;
    private Integer idTipoServicio;
    private Integer idDia;
}
