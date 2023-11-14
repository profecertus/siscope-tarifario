package pe.com.isesystem.siscopetarifario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "semana")
public class Semana {
    @Id
    @Column(name = "id_semana", nullable = false)
    private Integer id;

    @Column(name = "fecha_inicio", nullable = false)
    private Integer fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private Integer fechaFin;

    @Column(name = "tipo_semana", nullable = false, length = Integer.MAX_VALUE)
    private String tipoSemana;

    @Column(name = "estado")
    private Boolean estado;

}