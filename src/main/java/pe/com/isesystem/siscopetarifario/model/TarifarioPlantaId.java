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
public class TarifarioPlantaId implements Serializable {
    private static final long serialVersionUID = -6695198832952533221L;
    @Column(name = "id_dia", nullable = false)
    private Long idDia;

    @Column(name = "id_planta", nullable = false)
    private Long idPlanta;

    @Column(name = "id_proveedor", nullable = false)
    private Long idProveedor;

    @Column(name = "id_tipo_servicio", nullable = false)
    private Long idTipoServicio;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TarifarioPlantaId entity = (TarifarioPlantaId) o;
        return Objects.equals(this.idDia, entity.idDia) &&
                Objects.equals(this.idProveedor, entity.idProveedor) &&
                Objects.equals(this.idPlanta, entity.idPlanta) &&
                Objects.equals(this.idTipoServicio, entity.idTipoServicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDia, idProveedor, idPlanta, idTipoServicio);
    }

}