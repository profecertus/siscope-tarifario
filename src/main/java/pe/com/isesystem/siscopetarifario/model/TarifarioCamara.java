package pe.com.isesystem.siscopetarifario.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = "TarifarioCamara")
@Table(name = "tarifario_camara")
public class TarifarioCamara {
    @EmbeddedId
    private TarifarioCamaraId id;

    @MapsId("idPlanta")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_planta", nullable = false)
    private Planta idPlanta;

    @MapsId("placa")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "placa", nullable = false)
    private Camara placa;

    @MapsId("idDia")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_dia", nullable = false)
    private DiaSemana idDia;


    @MapsId("idMoneda")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_moneda", nullable = false)
    private Moneda idMoneda;

    @Column(name = "monto", precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "estado_reg")
    private Boolean estadoReg;

}