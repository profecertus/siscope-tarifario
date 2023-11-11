package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UnidadMedidaDTO implements  Serializable{
    private Long idUm;
    private String nombre;
    private String abreviatura;
    private Boolean estado;
    private Boolean estadoReg;

}
