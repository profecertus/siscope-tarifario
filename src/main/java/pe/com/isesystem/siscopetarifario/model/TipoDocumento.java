package pe.com.isesystem.siscopetarifario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = "TipoDocumento")
@Table(name = "TIPO_DOCUMENTO")
public class TipoDocumento {
    @Id
    @Column(name = "ID_TIPODOC", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 20)
    private String nombre;

    @Column(name = "ABREVIATURA", nullable = false, length = 4)
    private String abreviatura;

    @Column(name = "ESTADO", nullable = false)
    private Boolean estado = false;

    @Column(name = "ESTADO_REG", nullable = false)
    private Boolean estadoReg = false;

}