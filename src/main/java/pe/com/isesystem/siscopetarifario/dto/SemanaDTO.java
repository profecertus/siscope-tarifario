package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SemanaDTO implements Serializable{
    private Long id;
    private Long fechaInicio;
    private Long fechaFin;
    private String tipoSemana;
    private Boolean estado;

}
