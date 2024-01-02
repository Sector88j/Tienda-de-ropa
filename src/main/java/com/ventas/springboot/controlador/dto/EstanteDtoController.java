package com.ventas.springboot.controlador.dto;

import com.ventas.springboot.modelo.entidades.dto.EstanteDTO;
import com.ventas.springboot.modelo.entidades.entity.Estante;
import com.ventas.springboot.modelo.entidades.mapper.mapstruct.EstanteMapperMS;
import com.ventas.springboot.service.contratos.EstanteDAO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RequestMapping("/estantes")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "true")
@Api(value = "Acciones relacionadas sobre cambio de estantes", tags = "Acciones sobre Estantes")
public class EstanteDtoController extends GenericDtoController<Estante, EstanteDAO>{

    @Autowired
    private EstanteMapperMS mapper;

    public EstanteDtoController(EstanteDAO service){
        super(service,  "Ropa");
    }

    @GetMapping
    @ApiOperation(value = "Consultar todos los estantes")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ejecutado satisfactoriamente")
    })
    public ResponseEntity<?> obtenerEstantes(){
        Map<String, Object> mensaje = new HashMap<>();
        List<Estante> estantes = super.obtenerTodos();

        if(estantes.isEmpty()){
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("", numero_entidades));
            return ResponseEntity.badRequest().body(mensaje);
        }
        List<EstanteDTO> estanteDTOS = estantes
                .stream()
                .map(mapper::mapEstante)
                .collect(Collectors.toList());
        mensaje.put("success", Boolean.TRUE);
        mensaje.put("data", estanteDTOS);

        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Consultar estante por id")
    public ResponseEntity<?> obtenerEstantePorId(@PathVariable @ApiParam(name = "Codigo del sistema") Integer id){
        return ResponseEntity.ok("");
    }
}
