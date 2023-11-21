package com.ventas.springboot.modelo.entidades.mapper.mapstruct;

import com.ventas.springboot.modelo.entidades.dto.RopaDTO;
import com.ventas.springboot.modelo.entidades.entity.Ropa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = RopaMapper.class)
public abstract class RopaMapper {
    public abstract RopaDTO mapRopa(Ropa ropa);
    public abstract Ropa mapRopa(RopaDTO ropaDTO);
}
