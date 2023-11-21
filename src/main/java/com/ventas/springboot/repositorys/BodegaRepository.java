package com.ventas.springboot.repositorys;

import com.ventas.springboot.modelo.entidades.entity.Bodega;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface BodegaRepository extends CrudRepository<Bodega, Integer> {

    @Query("select b from Bodega b where UPPER(b.numero) = UPPER(?1)")
    Optional<Bodega> findBodegaByNumeroIgnoreCase(String nombre);

    Iterable<Bodega> findBodegaByFechaEntradaBetween(LocalDateTime desde, LocalDateTime hasta);
}
