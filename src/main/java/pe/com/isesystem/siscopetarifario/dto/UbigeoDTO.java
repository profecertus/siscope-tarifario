package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UbigeoDTO implements Serializable {
    private String codUbigeo;
    private String departamento;
    private String provincia;
    private String distrito;
    private Number superficie;
    private Number posx;
    private Number posy;
    private Boolean estadoReg;
}
