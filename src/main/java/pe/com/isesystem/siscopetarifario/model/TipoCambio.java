package pe.com.isesystem.siscopetarifario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "tipo_cambio")
public class TipoCambio {
    @EmbeddedId
    private TipoCambioId id;

    @Column(name = "valor_cambio", precision = 10, scale = 4)
    private BigDecimal valorCambio;

    private String nombreDia;

}