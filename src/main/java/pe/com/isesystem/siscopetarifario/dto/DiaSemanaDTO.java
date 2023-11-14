package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DiaSemanaDTO implements Serializable {
    private Long idDia;
    private SemanaDTO idSemana;
    private String nombreDia;
    private String caracteristica;
}
