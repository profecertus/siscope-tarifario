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
@Entity(name = "Semana")
@Table(name = "SEMANA")
public class Semana {
    @Id
    @Column(name = "ID_ANIO", nullable = false)
    private Long id;

    @Column(name = "FECHA_INICIO", nullable = false)
    private Long fechaInicio;

    @Column(name = "FECHA_FIN", nullable = false)
    private Long fechaFin;

    @Column(name = "TIPO_SEMANA", nullable = false)
    private String tipoSemana;

    @Column(name = "ESTADO", nullable = false)
    private Boolean estado;

}