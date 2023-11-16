package pe.com.isesystem.siscopetarifario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.isesystem.siscopetarifario.model.TarifarioEmbarcacion;
import pe.com.isesystem.siscopetarifario.model.TarifarioEmbarcacionId;
import pe.com.isesystem.siscopetarifario.model.TarifarioGeneral;

import java.util.List;

@Repository
public interface TarifarioEmbarcacionRepository extends JpaRepository<TarifarioEmbarcacion, TarifarioEmbarcacionId> {

    <S extends TarifarioEmbarcacion> List<S> findAllById_IdDia(Long IdDia);

}
