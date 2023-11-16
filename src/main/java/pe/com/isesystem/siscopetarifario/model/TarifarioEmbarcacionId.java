package pe.com.isesystem.siscopetarifario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class TarifarioEmbarcacionId implements Serializable {
    private static final long serialVersionUID = 5782810564292637152L;
    @Column(name = "id_dia", nullable = false)
    private Integer idDia;

    @Column(name = "id_embarcacion", nullable = false)
    private Integer idEmbarcacion;

    @Column(name = "id_proveedor", nullable = false)
    private Integer idProveedor;

    @Column(name = "id_tipo_servicio", nullable = false)
    private Integer idTipoServicio;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TarifarioEmbarcacionId entity = (TarifarioEmbarcacionId) o;
        return Objects.equals(this.idDia, entity.idDia) &&
                Objects.equals(this.idProveedor, entity.idProveedor) &&
                Objects.equals(this.idEmbarcacion, entity.idEmbarcacion) &&
                Objects.equals(this.idTipoServicio, entity.idTipoServicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDia, idProveedor, idEmbarcacion, idTipoServicio);
    }

}