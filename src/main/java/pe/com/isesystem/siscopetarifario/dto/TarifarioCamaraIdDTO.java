package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TarifarioCamaraIdDTO implements Serializable {
    private String codUbigeo;
    private String placa;
    private Long idDia;
}
