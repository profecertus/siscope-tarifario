package pe.com.isesystem.siscopetarifario.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import pe.com.isesystem.siscopetarifario.model.TarifarioFlete;
import pe.com.isesystem.siscopetarifario.model.TarifarioFleteId;


import java.util.List;
import java.util.function.Function;


@Repository
public interface TarifarioFleteRepository extends JpaRepository<TarifarioFlete, TarifarioFleteId> {

    <S extends TarifarioFlete> List<S> findAllById_IdDia(Long IdDia);

    <S extends TarifarioFlete, R> R findById_IdDiaAndAndId_CodUbigeoDestino(Long dia, String ubigeo);
}
