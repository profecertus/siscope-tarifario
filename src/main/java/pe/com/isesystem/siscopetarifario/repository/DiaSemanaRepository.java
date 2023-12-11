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

    @Query(value = "SELECT * " +
            "FROM dia_semana where id_semana = :numeroSemana " +
            "and id_dia <= CAST(TO_CHAR( CURRENT_TIMESTAMP AT TIME ZONE 'America/Lima', 'YYYYMMDD') AS NUMERIC ) " +
            "order by id_dia",nativeQuery = true)
    List<DiaSemana> getAllDaysFromWeek(@Param("numeroSemana") Long numeroSemana );


}
