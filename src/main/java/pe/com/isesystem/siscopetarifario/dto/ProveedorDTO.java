package pe.com.isesystem.siscopetarifario.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProveedorDTO implements  Serializable{
    private Long idProveedor;
    private String razonSocial;
    private String nombreComercial;
    private TipoDocumentoDTO idTipodoc;
    private String numeroDocumento;
    private String direccion;
    private String telefono;
    private String correo;
    private Boolean estado;
    private Boolean estadoReg;
}
