package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlantaDTO implements Serializable {
    private Long idPlanta;
    private String nombre;
    private String ruc;
    private String direccion;
    private String codUbigeo;
    private Boolean estado;
    private Boolean estadoReg;
}
