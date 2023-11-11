package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MonedaDTO implements Serializable {
    private Long idMoneda;
    private String nombre;
    private String abreviatura;
}
