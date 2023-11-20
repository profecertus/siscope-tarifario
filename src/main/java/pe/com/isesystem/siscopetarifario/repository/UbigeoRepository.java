package pe.com.isesystem.siscopetarifario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.isesystem.siscopetarifario.model.Ubigeo;

@Repository
public interface UbigeoRepository extends JpaRepository<Ubigeo, String> {

}
