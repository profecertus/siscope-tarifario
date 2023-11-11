package pe.com.isesystem.siscopetarifario.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = "TipoServicio")
@Table(name = "TIPO_SERVICIO")
public class TipoServicio {
    @Id
    @Column(name = "ID_TIPO_SERVICIO", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_UM", nullable = false)
    private UnidadMedida idUm;

    @Column(name = "ESTADO", nullable = false)
    private Boolean estado;

    @Column(name = "ESTADO_REG", nullable = false)
    private Boolean estadoReg = false;

}