package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoCambioDTO {
    private TipoCambioIdDTO id;
    private BigDecimal valorCambio;
    private String nombreDia;
}
