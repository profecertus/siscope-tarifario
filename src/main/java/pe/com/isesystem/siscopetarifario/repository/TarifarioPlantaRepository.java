package pe.com.isesystem.siscopetarifario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.isesystem.siscopetarifario.model.TarifarioPlanta;
import pe.com.isesystem.siscopetarifario.model.TarifarioPlantaId;

import java.util.List;

@Repository
public interface TarifarioPlantaRepository extends JpaRepository<TarifarioPlanta, TarifarioPlantaId> {
    <S extends TarifarioPlanta> List<S> findAllById_IdDia(Long IdDia);

    @Override
    <S extends TarifarioPlanta> S save(S entity);

    @Query(value = "select jsonb_build_object( 'monto', e.monto, 'moneda', m.nombre, 'idMoneda', m.id_moneda ) " +
            "from tarifario_planta e " +
            "inner join moneda m " +
            "on e.id_moneda = m.id_moneda " +
            "where e.id_dia = :IdDia " +
            "and e.id_planta = :IdPlanta " +
            "and e.id_tipo_servicio = :IdTipoServicio " +
            "and e.estado = true ",nativeQuery = true)
    Object getTarifarioPlanta(Long IdDia, Long IdPlanta, Long IdTipoServicio);
}
