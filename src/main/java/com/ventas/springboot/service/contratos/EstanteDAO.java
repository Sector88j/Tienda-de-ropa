package com.ventas.springboot.service.contratos;

import com.ventas.springboot.modelo.entidades.entity.Estante;
import com.ventas.springboot.modelo.entidades.enumeradores.Vestimenta;

import java.util.Optional;

public interface EstanteDAO extends GenericoDAO<Estante>{
    Iterable<Estante> findEstantesByVestimenta(Vestimenta vestimenta);
    Iterable<Estante> findEstantesByBodegaNumero(String numero);
    Optional<Estante> findEstantesByNroEstante(Integer nroEstante);
}
