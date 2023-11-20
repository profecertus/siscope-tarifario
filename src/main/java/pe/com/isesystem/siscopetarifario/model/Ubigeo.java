package pe.com.isesystem.siscopetarifario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "ubigeo")
public class Ubigeo {
    @Id
    @Column(name = "cod_ubigeo", nullable = false, length = 10)
    private String codUbigeo;

    @Column(name = "departamento", length = 50)
    private String departamento;

    @Column(name = "provincia", length = 50)
    private String provincia;

    @Column(name = "distrito", length = 50)
    private String distrito;

    @Column(name = "superficie", precision = 10, scale = 4)
    private BigDecimal superficie;

    @Column(name = "posx", precision = 10, scale = 4)
    private BigDecimal posx;

    @Column(name = "posy", precision = 10, scale = 4)
    private BigDecimal posy;

    @Column(name = "estado_reg")
    private Boolean estadoReg;

}