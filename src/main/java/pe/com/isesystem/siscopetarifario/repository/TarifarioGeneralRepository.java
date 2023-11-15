package pe.com.isesystem.siscopetarifario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.com.isesystem.siscopetarifario.model.TarifarioGeneral;
import pe.com.isesystem.siscopetarifario.model.TarifarioGeneralId;

import java.util.List;

@Repository
public interface TarifarioGeneralRepository extends JpaRepository<TarifarioGeneral, TarifarioGeneralId> {
    <S extends TarifarioGeneral> List<S> findAllById_IdDia(Long IdDia);

    @Override
    <S extends TarifarioGeneral> S save(S entity);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO TARIFARIO_GENERAL(id_proveedor, id_tipo_servicio, id_dia, id_moneda, monto,estado, estado_reg)\n" +
            "SELECT ID_PROVEEDOR, id_tipo_servicio, CAST(:dia AS INTEGER), id_moneda, monto,estado, estado_reg\n" +
            "FROM tarifario_general\n" +
            "WHERE id_dia in (\n" +
            "        select id_dia from dia_semana\n" +
            "        where id_dia < CAST(:dia AS INTEGER) \n" +
            "        order by id_dia DESC\n" +
            "        LIMIT 1\n" +
            ")", nativeQuery = true)
    int createTarifas(@Param("dia") String dia);



}
