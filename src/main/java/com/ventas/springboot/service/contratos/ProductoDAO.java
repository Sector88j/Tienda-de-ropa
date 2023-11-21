package com.ventas.springboot.service.contratos;

import com.ventas.springboot.modelo.entidades.entity.Producto;

import java.util.Optional;

public interface ProductoDAO extends GenericoDAO<Producto> {
    Optional<Producto> buscarPorNombreYNombreMarca(String nombre, String nombreMarca);
    Optional<Producto> buscarPorNumeroArticulo(String numeroArticulo);
    Optional<Producto> buscarProductoPorNombreMarca(String nombreMarca);
}
