package com.ventas.springboot.modelo.entidades.dto;

import com.ventas.springboot.modelo.entidades.entity.LugarOrigen;
import com.ventas.springboot.modelo.entidades.entity.enumeradores.TipoRopa;
import com.ventas.springboot.modelo.entidades.entity.enumeradores.Vestimenta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class RopaDTO extends ProductoDTO{
    private BigDecimal precio;
    private Vestimenta vestimenta;
    private TipoRopa tipoRopa;

    public RopaDTO(Integer id, String nombre, String nombreMarca, String numeroArticulo, Vestimenta vestimenta, BigDecimal precio, TipoRopa tipoRopa , LugarOrigen lugarOrigen){
        super(id, nombre, nombreMarca, numeroArticulo, lugarOrigen);
        this.vestimenta = vestimenta;
        this.precio = precio;
        this.tipoRopa = tipoRopa;
    }
}
