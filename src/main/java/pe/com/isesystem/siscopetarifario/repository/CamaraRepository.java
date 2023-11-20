package pe.com.isesystem.siscopetarifario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.isesystem.siscopetarifario.model.Camara;

@Repository
public interface CamaraRepository extends JpaRepository<Camara, String> {
}
