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
    @ApiModelProperty(name = "Codigo del sistema", example = "5")
    private Integer codigo;
    @NotNull
    @NotEmpty(message = "Debe de ingresar un valor")
    @Size(min = 0, max = 80)
    @ApiModelProperty(name = "Numero del estante", example = "Estante 12", required = true)
    private Integer NroEstante;
    @Positive(message = "El valor no puede ser negativo")
    @ApiModelProperty(name = "Cantidad de Ropa de todo el estante", example = "55", required = true)
    private Integer cantidadRopa;

}
