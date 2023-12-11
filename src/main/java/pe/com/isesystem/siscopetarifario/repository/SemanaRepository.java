package pe.com.isesystem.siscopetarifario.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.com.isesystem.siscopetarifario.model.Semana;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface SemanaRepository extends JpaRepository<Semana, Long> {

    @Query(value = "select  * from semana order by id_anio desc limit 1",nativeQuery = true)
    <S extends Semana> Optional<S> getLastWeekSave();

    @Query(value = "SELECT * FROM semana WHERE fecha_inicio <= CAST(:fecha AS INTEGER) AND fecha_fin >= CAST(:fecha AS INTEGER)", nativeQuery = true)
    Optional<Semana> getWeek(@Param("fecha") String fecha);

    @Override
    <S extends Semana> S save(S entity);

    @Override
    Optional<Semana> findById(Long aLong);

    @Override
    Page<Semana> findAll(Pageable pageable);

    @Query(value = "SELECT CURRENT_TIMESTAMP AT TIME ZONE 'America/Lima'", nativeQuery = true)
    Date getAhora();

    @Query(value = "SELECT CAST(TO_CHAR( CURRENT_TIMESTAMP AT TIME ZONE 'America/Lima', 'YYYYMMDD') AS NUMERIC )", nativeQuery = true)
    Long getFecha();

}
