package com.ventas.springboot.controlador;

import com.ventas.springboot.exeption.BadRequestException;
import com.ventas.springboot.modelo.entidades.entity.Producto;
import com.ventas.springboot.service.contratos.ProductoDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Deprecated
public class ProductoController extends GenericController<Producto, ProductoDAO>{

    public ProductoController(ProductoDAO service){
        super(service);
    }

    @GetMapping("/nombre-numeroArticulo")
    public ResponseEntity<?> buscarProductoPorNombreYNombreMarca(@RequestParam String nombre, @RequestParam String nombreMarca){
        Map<String, Object> mensaje = new HashMap<>();
        Optional<Producto> oProducto = service.buscarPorNombreYNombreMarca(nombre, nombreMarca);
        if(!oProducto.isPresent()){
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("No se encontro Producto con nombre %s y nombreMarca %s", nombre, nombreMarca));
            return ResponseEntity.badRequest().body(mensaje);
        }
        mensaje.put("success", Boolean.TRUE);
        mensaje.put("datos", oProducto.get());

        return ResponseEntity.ok(mensaje);
    }
}
