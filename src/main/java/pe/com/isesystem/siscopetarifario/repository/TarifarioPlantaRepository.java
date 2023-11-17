package pe.com.isesystem.siscopetarifario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.isesystem.siscopetarifario.model.TarifarioPlanta;
import pe.com.isesystem.siscopetarifario.model.TarifarioPlantaId;

import java.util.List;

@Repository
public interface TarifarioPlantaRepository extends JpaRepository<TarifarioPlanta, TarifarioPlantaId> {
    <S extends TarifarioPlanta> List<S> findAllById_IdDia(Long IdDia);
}
