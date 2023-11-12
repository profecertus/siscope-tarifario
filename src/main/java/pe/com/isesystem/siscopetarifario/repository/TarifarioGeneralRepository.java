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
    <S extends TarifarioGeneral> List<S> findAllById_IdAnio(Long IdAnio);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tarifario_general(id_proveedor, id_tipo_servicio, id_anio, estado, estado_reg)\n" +
            "SELECT id_proveedor, id_tipo_servicio, CAST(:semana AS INTEGER), true, true\n" +
            "FROM rel_prov_tiposerv\n" +
            "WHERE estado = true AND estado_reg = true\n" +
            "  AND NOT EXISTS (\n" +
            "    SELECT 1\n" +
            "    FROM tarifario_general\n" +
            "    WHERE tarifario_general.id_proveedor = rel_prov_tiposerv.id_proveedor\n" +
            "      AND tarifario_general.id_tipo_servicio = rel_prov_tiposerv.id_tipo_servicio\n" +
            "      AND tarifario_general.id_anio = CAST(:semana AS INTEGER)\n" +
            ")", nativeQuery = true)
    int createNewWeek(@Param("semana") String semana);

}
