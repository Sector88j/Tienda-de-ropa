package com.ventas.springboot.controlador.dto;

import com.ventas.springboot.modelo.entidades.dto.ProductoDTO;
import com.ventas.springboot.modelo.entidades.entity.Producto;
import com.ventas.springboot.modelo.entidades.entity.Ropa;
import com.ventas.springboot.modelo.entidades.mapper.mapstruct.RopaMapper;
import com.ventas.springboot.service.contratos.ProductoDAO;

import java.util.Optional;

public class ProductoDtoController extends GenericDtoController<Producto, ProductoDAO>{
    protected final RopaMapper ropaMapper;

    public ProductoDtoController(ProductoDAO service, String numero_entidades, RopaMapper ropaMapper){
       super(service, numero_entidades);
       this.ropaMapper = ropaMapper;
    }

    public ProductoDTO numeroArticulo(Producto producto){
        Producto productoEntidades = super.altaEntidad(producto);
        ProductoDTO dto = null;
        if (productoEntidades instanceof Ropa){
            dto = ropaMapper.mapRopa((Ropa) productoEntidades);
        }
        return dto;
    }

    public ProductoDTO buscarProductoPorId(Integer id){
        Optional<Producto> oProducto = super.obtenerPorId(id);
        Producto producto;
        ProductoDTO dto = null;
        if (oProducto.isEmpty()){
            return null;
        }else {
            producto = oProducto.get();
        }
        if (producto instanceof Ropa){
            dto = ropaMapper.mapRopa((Ropa) producto);
        }
        return dto;
    }
}
