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
@Entity(name = "UnidadMedida")
@Table(name = "UNIDAD_MEDIDA")
public class UnidadMedida {
    @Id
    @Column(name = "ID_UM", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 30)
    private String nombre;

    @Column(name = "ABREVIATURA", nullable = false, length = 5)
    private String abreviatura;

    @Column(name = "ESTADO", nullable = false)
    private Boolean estado = false;

    @Column(name = "ESTADO_REG", nullable = false)
    private Boolean estadoReg = false;

}