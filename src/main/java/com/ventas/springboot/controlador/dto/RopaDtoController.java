package com.ventas.springboot.controlador.dto;

import com.ventas.springboot.modelo.entidades.dto.ProductoDTO;
import com.ventas.springboot.modelo.entidades.dto.RopaDTO;
import com.ventas.springboot.modelo.entidades.mapper.mapstruct.RopaMapper;
import com.ventas.springboot.service.contratos.ProductoDAO;
import jakarta.validation.Valid;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ropas")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "true")
public class RopaDtoController extends ProductoDtoController{
    public RopaDtoController(ProductoDAO service, RopaMapper ropaMapper){
        super(service, "Ropa", ropaMapper);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerRopaPorId(@PathVariable Integer id){
        Map<String, Object> mensaje = new HashMap<>();
        ProductoDTO dto = super.buscarProductoPorId(id);

        if (dto == null){
            mensaje.put("succes", Boolean.FALSE);
            mensaje.put("mensajes", String.format("No existe %s con ID %d", numero_entidades, id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        mensaje.put("success", Boolean.TRUE);
        mensaje.put("data", dto);

        return ResponseEntity.ok(mensaje);
    }

    @PostMapping
    public ResponseEntity<?> numeroRopa(@Valid @RequestBody ProductoDTO productoDTO, BindingResult result){
        Map<String, Object> mensaje = new HashMap<>();

        if (result.hasErrors()){
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("validaciones", super.obtenerValidaciones(result));
            return ResponseEntity.badRequest().body(mensaje);
        }
        ProductoDTO save = super.numeroArticulo(ropaMapper.mapRopa((RopaDTO) productoDTO));

        mensaje.put("succes", Boolean.TRUE);
        mensaje.put("data", save);

        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }
}
