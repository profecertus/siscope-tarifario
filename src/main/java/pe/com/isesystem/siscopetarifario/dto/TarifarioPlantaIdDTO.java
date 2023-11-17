package pe.com.isesystem.siscopetarifario.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TarifarioPlantaIdDTO implements Serializable {
    private Long idDia;
    private Long idPlanta;
    private Long idProveedor;
    private Long idTipoServicio;
}
