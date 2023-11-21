package com.ventas.springboot.modelo.entidades.mapper;

import com.ventas.springboot.modelo.entidades.dto.EstanteDTO;
import com.ventas.springboot.modelo.entidades.entity.Estante;

@Deprecated
public class CarreraMapper {
    public static EstanteDTO mapEstante(Estante estante){
        EstanteDTO dto = new EstanteDTO();
        dto.setCodigo(estante.getId());
        dto.setNroEstante(estante.getNroEstante());
        dto.setCantidadRopa(estante.getCantidadRopa());
        return dto;
    }
}
