package com.ventas.springboot.service.contratos;

import com.ventas.springboot.modelo.entidades.entity.Bodega;

import java.time.LocalDateTime;
import java.util.Optional;

public interface BodegaDAO extends GenericoDAO<Bodega>{
    Optional<Bodega> findBodegaByNumeroIgnoreCase(String nombre);
    Iterable<Bodega> findBodegaByFechaEntradaBetween(LocalDateTime desde, LocalDateTime hasta);
}

