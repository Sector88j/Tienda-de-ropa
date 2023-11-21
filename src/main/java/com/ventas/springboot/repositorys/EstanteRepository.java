package com.ventas.springboot.repositorys;

import com.ventas.springboot.modelo.entidades.entity.Estante;
import com.ventas.springboot.modelo.entidades.enumeradores.Vestimenta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EstanteRepository extends CrudRepository<Estante, Integer> {

    @Query("select e from Estante e where e.vestimenta=?1")
    Iterable<Estante> findEstantesByVestimenta(Vestimenta vestimenta);
    Iterable<Estante> findEstantesByBodegaNumero(String numero);
    Optional<Estante> findEstantesByNroEstante(Integer nroEstante);
}
