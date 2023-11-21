package com.ventas.springboot.service.implementaciones;

import com.ventas.springboot.modelo.entidades.entity.Producto;
import com.ventas.springboot.repositorys.ProductoRepository;
import com.ventas.springboot.service.contratos.ProductoDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class ProductoDAOImpl extends GenericoDAOImpl<Producto, ProductoRepository> implements ProductoDAO {

    public ProductoDAOImpl(ProductoRepository repository){
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> buscarPorNombreYNombreMarca(String nombre, String nombreMarca){
        return repository.buscarPorNombreYNombreMarca(nombre, nombreMarca);
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> buscarPorNumeroArticulo(String numeroArticulo){
        return repository.buscarPorNumeroArticulo(numeroArticulo);
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> buscarProductoPorNombreMarca(String nombreMarca){
        return repository.buscarProductoPorNombreMarca(nombreMarca);
    }
}
