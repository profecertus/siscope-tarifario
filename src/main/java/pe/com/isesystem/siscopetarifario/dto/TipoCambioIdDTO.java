package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoCambioIdDTO {
    private Integer idMoneda;
    private Long idDia;
}
