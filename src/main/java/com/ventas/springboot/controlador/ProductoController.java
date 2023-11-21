package com.ventas.springboot.controlador;

import com.ventas.springboot.exeption.BadRequestException;
import com.ventas.springboot.modelo.entidades.entity.Producto;
import com.ventas.springboot.service.contratos.ProductoDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


public class ProductoController extends GenericController<Producto, ProductoDAO>{

    public ProductoController(ProductoDAO service){
        super(service);
    }

    @GetMapping("/nombre-numeroArticulo")
    public Producto buscarProductoPorNombreYNombreMarca(@RequestParam String nombre, @RequestParam String nombreMarca){
        Optional<Producto> oProducto = service.buscarPorNombreYNombreMarca(nombre, nombreMarca);
        if(!oProducto.isPresent()){
            throw new BadRequestException(String.format("No se encontro Producto con nombre %s y nombreMarca %s",
                    nombre, nombreMarca));
        }
        return oProducto.get();
    }
}
