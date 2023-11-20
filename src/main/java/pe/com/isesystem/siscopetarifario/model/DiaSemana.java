package pe.com.isesystem.siscopetarifario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dia_semana")
public class DiaSemana {
    @Id
    @Column(name = "id_dia", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_semana")
    private Semana idSemana;

    @Column(name = "nombre_dia", nullable = false, length = 20)
    private String nombreDia;

    @Column(name = "caracteristica", length = Integer.MAX_VALUE)
    private String caracteristica;

}