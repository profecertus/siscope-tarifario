package pe.com.isesystem.siscopetarifario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.com.isesystem.siscopetarifario.model.Ubigeo;

import java.util.List;

@Repository
public interface UbigeoRepository extends JpaRepository<Ubigeo, String> {

    @Query(value = "select u.* from ubigeo u inner join planta p on u.cod_ubigeo = p.cod_ubigeo",nativeQuery = true)
    List<Ubigeo> getAllUbigeo();

}
