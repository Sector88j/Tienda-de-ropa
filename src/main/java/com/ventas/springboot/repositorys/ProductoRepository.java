package com.ventas.springboot.repositorys;


import com.ventas.springboot.modelo.entidades.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface ProductoRepository extends CrudRepository<Producto, Integer> {
    @Query("select p from Producto p where p.nombre = ?1 and p.nombreMarca = ?2")
    Optional<Producto> buscarPorNombreYNombreMarca(String nombre, String nombreMarca);

    @Query("select p from Producto p where p.numeroArticulo = ?1")
    Optional<Producto> buscarPorNumeroArticulo(String numeroArticulo);

    @Query("select p from Producto p where p.nombreMarca like %?1%")
    Optional<Producto> buscarProductoPorNombreMarca(String nombreMarca);
}
