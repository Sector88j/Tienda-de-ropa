package com.ventas.springboot.modelo.entidades.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Estante de bodega", value = "Estante", reference = "Estante")
public class EstanteDTO {

    @ApiModelProperty(name = "Codigo del Sistema", example = "5")
    private Integer codigo;
    @NotNull
    @Positive(message = "Debe de ingresar un valor")
    @ApiModelProperty(name = "Numero de estante", example = "Tipos de distribucion", required = true)
    private Integer nroEstante;
    @Positive
    @ApiModelProperty(notes = "Cantidad de ropa en el estante", example = "55", required = true)
    private Integer cantidadRopa;
}
