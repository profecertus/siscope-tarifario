package pe.com.isesystem.siscopetarifario.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = "Moneda")
@Table(name = "MONEDA")
public class Moneda {
    @Id
    @Column(name = "ID_MONEDA", nullable = false)
    private Long idMoneda;

    @Column(name = "NOMBRE", length = 20)
    private String nombre;

    @Nationalized
    @Column(name = "ABREVIATURA", length = 5)
    private String abreviatura;

}