package com.ventas.springboot.modelo.entidades.mapper.mapstruct;

import com.ventas.springboot.modelo.entidades.dto.ProductoDTO;
import com.ventas.springboot.modelo.entidades.entity.Producto;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface ProductoMapperConfig {
    void  mapProducto(Producto producto, @MappingTarget ProductoDTO productoDTO);
}
