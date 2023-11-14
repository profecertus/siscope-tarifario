package pe.com.isesystem.siscopetarifario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.isesystem.siscopetarifario.model.DiaSemana;

import java.util.Optional;

@Repository
public interface DiaSemanaRepository extends JpaRepository<DiaSemana, Long> {

    @Override
    <S extends DiaSemana> S save(S entity);

    @Override
    Optional<DiaSemana> findById(Long aLong);
}
