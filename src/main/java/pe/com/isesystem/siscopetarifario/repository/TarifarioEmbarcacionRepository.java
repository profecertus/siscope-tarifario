package pe.com.isesystem.siscopetarifario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.com.isesystem.siscopetarifario.model.TarifarioEmbarcacion;
import pe.com.isesystem.siscopetarifario.model.TarifarioEmbarcacionId;
import pe.com.isesystem.siscopetarifario.model.TarifarioGeneral;

import java.util.List;
import java.util.Optional;

@Repository
public interface TarifarioEmbarcacionRepository extends JpaRepository<TarifarioEmbarcacion, TarifarioEmbarcacionId> {

    <S extends TarifarioEmbarcacion> List<S> findAllById_IdDia(Long IdDia);



    @Query(value = "select jsonb_build_object( 'monto', e.monto, 'moneda', m.nombre, 'idMoneda', m.id_moneda ) " +
            "from tarifario_embarcacion e " +
            "inner join moneda m " +
            "on e.id_moneda = m.id_moneda " +
            "where e.id_dia = :IdDia " +
            "and e.id_embarcacion = :IdEmbarcacion " +
            "and e.id_tipo_servicio = :IdTipoServicio " +
            "and e.estado = true ",nativeQuery = true)
    Object getTarifarioEmbarcacion(Long IdDia, Long IdEmbarcacion, Long IdTipoServicio);
}
