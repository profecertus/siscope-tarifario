package pe.com.isesystem.siscopetarifario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "tarifario_flete")
public class TarifarioFlete {
    @EmbeddedId
    private TarifarioFleteId id;

    @MapsId("idDia")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_dia", nullable = false)
    private DiaSemana idDia;

    @MapsId("codUbigeoDestino")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cod_ubigeo_destino", nullable = false)
    private Ubigeo codUbigeoDestino;

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