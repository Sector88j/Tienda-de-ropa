package com.ventas.springboot.modelo.entidades.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ventas.springboot.modelo.entidades.entity.LugarOrigen;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = RopaDTO.class, name = "ropa"),
})

public abstract class ProductoDTO {
    private Integer id;
    private String nombre;
    private String nombreMarca;
    @Pattern(regexp = "[0-9]+")
    @Size(min = 1, max = 10)
    private String numeroArticulo;
    private LugarOrigen lugarOrigen;
}
