package pe.com.isesystem.siscopetarifario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.isesystem.siscopetarifario.model.TipoCambio;
import pe.com.isesystem.siscopetarifario.model.TipoCambioId;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface TipoCambioRepository extends JpaRepository<TipoCambio, TipoCambioId> {

    @Query(value = "select valor_cambio from tipo_cambio where id_dia = CAST(TO_CHAR( CURRENT_TIMESTAMP AT TIME ZONE 'America/Lima', 'YYYYMMDD') AS NUMERIC ) and id_moneda = 2", nativeQuery = true)
    BigDecimal findTipoCambioHoy();

    @Override
    Optional<TipoCambio> findById(TipoCambioId tipoCambioId);

    @Override
    <S extends TipoCambio> S save(S entity);

    @Override
    List<TipoCambio> findAll();
}
