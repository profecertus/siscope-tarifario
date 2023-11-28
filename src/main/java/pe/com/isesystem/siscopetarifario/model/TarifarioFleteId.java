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
public class TarifarioFleteId implements Serializable {
    private static final long serialVersionUID = 1916753124653847548L;
    @Column(name = "cod_ubigeo_origen", nullable = false, length = 10)
    private String codUbigeoOrigen;

    @Column(name = "cod_ubigeo_destino", nullable = false, length = 10)
    private String codUbigeoDestino;

    @Column(name = "id_dia", nullable = false)
    private Integer idDia;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TarifarioFleteId entity = (TarifarioFleteId) o;
        return Objects.equals(this.codUbigeoDestino, entity.codUbigeoDestino) &&
                Objects.equals(this.codUbigeoOrigen, entity.codUbigeoOrigen) &&
                Objects.equals(this.idDia, entity.idDia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codUbigeoDestino, codUbigeoOrigen, idDia);
    }

}