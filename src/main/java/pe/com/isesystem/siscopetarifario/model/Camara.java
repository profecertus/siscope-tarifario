package pe.com.isesystem.siscopetarifario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "camara")
public class Camara {
    @Id
    @Column(name = "placa", nullable = false, length = 10)
    private String placa;

    @Column(name = "marca", length = 50)
    private String marca;

    @Column(name = "modelo", length = 50)
    private String modelo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor idProveedor;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "estado_reg")
    private Boolean estadoReg;

}