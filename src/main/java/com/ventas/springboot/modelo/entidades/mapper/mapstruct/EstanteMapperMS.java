package com.ventas.springboot.modelo.entidades.mapper.mapstruct;

import com.ventas.springboot.modelo.entidades.dto.EstanteDTO;
import com.ventas.springboot.modelo.entidades.entity.Estante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EstanteMapperMS {
    @Mappings({
          @Mapping(source = "id", target = "codigo"),
          @Mapping(source = "nroEstante", target = "numero_estante"),
          @Mapping(source = "cantidadRopa", target = "cantidad_ropa"),
    })
    EstanteDTO mapEstante(Estante estante);
}
