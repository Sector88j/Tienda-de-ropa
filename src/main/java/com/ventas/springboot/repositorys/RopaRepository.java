package com.ventas.springboot.repositorys;

import com.ventas.springboot.modelo.entidades.entity.Producto;
import com.ventas.springboot.modelo.entidades.enumeradores.TipoRopa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioRopas")
public interface RopaRepository extends ProductoRepository {
    @Query("select r from Ropa r where r.tipoRopa=?1")
    Iterable<Producto> buscarRopasPorTipoRopa(TipoRopa tipoRopa);
}
