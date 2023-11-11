package pe.com.isesystem.siscopetarifario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.isesystem.siscopetarifario.model.Semana;

@Repository
public interface SemanaRepository extends JpaRepository<Semana, Long> {
}