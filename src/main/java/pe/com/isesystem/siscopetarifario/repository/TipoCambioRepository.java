package pe.com.isesystem.siscopetarifario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pe.com.isesystem.siscopetarifario.model.TipoCambio;
import pe.com.isesystem.siscopetarifario.model.TipoCambioId;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface TipoCambioRepository extends JpaRepository<TipoCambio, TipoCambioId> {

    @Query(value = "select valor_cambio from tipo_cambio where id_dia = CAST(TO_CHAR( CURRENT_TIMESTAMP AT TIME ZONE 'America/Lima', 'YYYYMMDD') AS NUMERIC ) and id_moneda = 2", nativeQuery = true)
    BigDecimal findTipoCambioHoy();

    @Query(value = "select valor_cambio from tipo_cambio where id_dia = :idDia and id_moneda = 2", nativeQuery = true)
    BigDecimal findByDia(@Param("idDia")Long idDia);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tipo_cambio (id_moneda, id_dia, valor_cambio) " +
            "VALUES (:idMoneda, :idDia, :monto) " +
            "ON CONFLICT (id_moneda, id_dia) DO UPDATE " +
            "SET valor_cambio = :monto", nativeQuery = true)
    int saveCustomized(@Param("idMoneda")Integer idMoneda, @Param("idDia")Long idDia, @Param("monto")BigDecimal monto);

    @Query(value="select tc.id_moneda, tc.id_dia, tc.valor_cambio, ds.nombre_dia " +
            "from tipo_cambio tc " +
            "inner join dia_semana ds " +
            "on tc.id_dia = ds.id_dia", nativeQuery = true)
    List<TipoCambio> findAllCustomized();
}
