package pe.com.isesystem.siscopetarifario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.isesystem.siscopetarifario.model.TarifarioCamara;
import pe.com.isesystem.siscopetarifario.model.TarifarioCamaraId;
import pe.com.isesystem.siscopetarifario.model.TarifarioPlanta;

import java.util.List;


@Repository
public interface TarifarioCamaraRepository extends JpaRepository<TarifarioCamara, TarifarioCamaraId> {

    <S extends TarifarioCamara> List<S> findAllById_IdDia(Long IdDia);

}
