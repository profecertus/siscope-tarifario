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
@Entity(name = "Proveedor")
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @Column(name = "id_proveedor", nullable = false)
    private Integer id;

    @Column(name = "razon_social", nullable = false, length = 100)
    private String razonSocial;

    @Column(name = "nombre_comercial", length = 100)
    private String nombreComercial;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ID_TIPODOC", nullable = false)
    private TipoDocumento idTipodoc;

    @Column(name = "numero_documento", nullable = false, length = 20)
    private String numeroDocumento;

    @Column(name = "direccion", length = 100)
    private String direccion;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "correo", length = 70)
    private String correo;

    @Column(name = "estado", nullable = false)
    private Boolean estado = false;

    @Column(name = "estado_reg", nullable = false)
    private Boolean estadoReg = false;

}