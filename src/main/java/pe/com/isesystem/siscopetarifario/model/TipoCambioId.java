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
public class TipoCambioId implements Serializable {
    private static final long serialVersionUID = -204646157596124698L;
    @Column(name = "id_moneda", nullable = false)
    private Integer idMoneda;

    @Column(name = "id_dia", nullable = false)
    private Integer idDia;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TipoCambioId entity = (TipoCambioId) o;
        return Objects.equals(this.idDia, entity.idDia) &&
                Objects.equals(this.idMoneda, entity.idMoneda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDia, idMoneda);
    }

}