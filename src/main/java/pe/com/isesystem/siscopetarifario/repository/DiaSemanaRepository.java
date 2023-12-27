package pe.com.isesystem.siscopetarifario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.com.isesystem.siscopetarifario.model.DiaSemana;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiaSemanaRepository extends JpaRepository<DiaSemana, Long> {

    @Override
    <S extends DiaSemana> S save(S entity);

    @Override
    Optional<DiaSemana> findById(Long aLong);

    @Query(value = "SELECT jsonb_build_object( " +
            "'idDia', ds.id_dia, " +
            "'idSemana', ds.id_semana, " +
            "'nombreDia', trim(ds.nombre_dia), " +
            "'caracteristica', ds.caracteristica, " +
            "'valorCambio', tc.valor_cambio " +
            ") AS resultado_json " +
            "FROM dia_semana ds " +
            "INNER JOIN tipo_cambio tc ON ds.id_dia = tc.id_dia " +
            "WHERE ds.id_semana = :numeroSemana " +
            "  AND ds.id_dia <= CAST(TO_CHAR(CURRENT_TIMESTAMP AT TIME ZONE 'America/Lima', 'YYYYMMDD') AS NUMERIC) " +
            "ORDER BY ds.id_dia;",nativeQuery = true)
    List<Object> getAllDaysFromWeek(@Param("numeroSemana") Long numeroSemana );


}
