package pe.com.isesystem.siscopetarifario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.isesystem.siscopetarifario.model.TarifarioGeneral;
import pe.com.isesystem.siscopetarifario.model.TarifarioGeneralId;

import java.util.List;

@Repository
public interface TarifarioGeneralRepository extends JpaRepository<TarifarioGeneral, TarifarioGeneralId> {
    <S extends TarifarioGeneral> List<S> findAllById_IdAnio(Long IdAnio);
}