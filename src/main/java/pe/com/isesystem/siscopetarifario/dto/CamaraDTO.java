package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CamaraDTO implements Serializable {
    private String placa;
    private String marca;
    private String modelo;
    private ProveedorDTO idProveedor;
    private Boolean estado;
    private Boolean estadoReg;
}
