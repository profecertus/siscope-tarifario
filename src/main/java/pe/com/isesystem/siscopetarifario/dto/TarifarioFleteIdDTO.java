package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TarifarioFleteIdDTO implements Serializable {
    private String codUbigeoOrigen;
    private String codUbigeoDestino;
    private Long idDia;
}
