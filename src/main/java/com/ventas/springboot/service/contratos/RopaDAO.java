package com.ventas.springboot.service.contratos;

import com.ventas.springboot.modelo.entidades.entity.Producto;
import com.ventas.springboot.modelo.entidades.entity.enumeradores.TipoRopa;

public interface RopaDAO extends ProductoDAO{
    Iterable<Producto> buscarRopasPorTipoRopa(TipoRopa tipoRopa);
}
