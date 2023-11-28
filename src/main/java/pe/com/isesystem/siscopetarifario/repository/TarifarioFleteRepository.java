package pe.com.isesystem.siscopetarifario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.isesystem.siscopetarifario.model.TarifarioFlete;
import pe.com.isesystem.siscopetarifario.model.TarifarioFleteId;


import java.util.List;


@Repository
public interface TarifarioFleteRepository extends JpaRepository<TarifarioFlete, TarifarioFleteId> {

    <S extends TarifarioFlete> List<S> findAllById_IdDia(Long IdDia);

}
