package pe.com.isesystem.siscopetarifario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class TarifarioGeneralId implements Serializable {
    private static final long serialVersionUID = -6880512574788144923L;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor idProveedor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "id_tipo_servicio", nullable = false)
    private TipoServicio idTipoServicio;

    @Column(name = "id_dia", nullable = false)
    private Long idDia;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TarifarioGeneralId entity = (TarifarioGeneralId) o;
        return Objects.equals(this.idProveedor, entity.idProveedor) &&
                Objects.equals(this.idDia, entity.idDia) &&
                Objects.equals(this.idTipoServicio, entity.idTipoServicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProveedor, idDia, idTipoServicio);
    }

}