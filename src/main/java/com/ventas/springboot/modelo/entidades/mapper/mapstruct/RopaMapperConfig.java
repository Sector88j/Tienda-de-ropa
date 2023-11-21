package com.ventas.springboot.modelo.entidades.mapper.mapstruct;

import com.ventas.springboot.modelo.entidades.dto.RopaDTO;
import com.ventas.springboot.modelo.entidades.entity.Ropa;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface RopaMapperConfig extends ProductoMapperConfig{
    @InheritConfiguration(name = "mapProducto")
    void mapRopa(Ropa ropa, @MappingTarget RopaDTO ropaDTO);
}
