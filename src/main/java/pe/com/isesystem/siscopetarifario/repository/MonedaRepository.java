package pe.com.isesystem.siscopetarifario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.isesystem.siscopetarifario.model.Moneda;

@Repository
public interface MonedaRepository extends JpaRepository<Moneda, Long> {
}