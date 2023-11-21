package com.ventas.springboot.modelo.entidades.dto;

import com.ventas.springboot.modelo.entidades.enumeradores.Vestimenta;
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

    public RopaDTO(Integer id, String nombre, String nombreMarca, String numeroArticulo, BigDecimal precio, Vestimenta vestimenta){
        super(id, nombre, nombreMarca, numeroArticulo);
        this.precio = precio;
        this.vestimenta = vestimenta;
    }
}
