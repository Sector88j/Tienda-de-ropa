package com.ventas.springboot.controlador;

import com.ventas.springboot.modelo.entidades.entity.Estante;
import com.ventas.springboot.modelo.entidades.entity.Producto;
import com.ventas.springboot.modelo.entidades.entity.Ropa;
import com.ventas.springboot.service.contratos.EstanteDAO;
import com.ventas.springboot.service.contratos.ProductoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Deprecated
@RequestMapping("/ropas")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "false")
public class RopaController extends ProductoController{
    private final EstanteDAO estanteDAO;

    @Autowired
    public RopaController(@Qualifier("ropaDAOImpl") ProductoDAO ropaDao, EstanteDAO estanteDAO){
        super(ropaDao);
        numeroEntidades = "Ropa";
        this.estanteDAO = estanteDAO;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarRopa(@PathVariable Integer id, @RequestBody Producto ropa){
        Map<String, Object> mensaje = new HashMap<>();
        Producto ropaUpdate = null;
        Optional<Producto> oRopa = service.findById(id);
        if (!oRopa.isPresent()){
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("Ropa con id %d no existe", id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        ropaUpdate = oRopa.get();
        ropaUpdate.setNombre(ropa.getNombre());
        ropaUpdate.setNombreMarca(ropa.getNombreMarca());
        ropaUpdate.setFechaDeLlegada(ropa.getFechaDeLlegada());

        mensaje.put("datos", service.save(ropaUpdate));
        mensaje.put("success", Boolean.TRUE);

        return ResponseEntity.ok(mensaje);
    }

    @PutMapping("/{idRopa}/estante/{idEstante}")
    public ResponseEntity<?> asignarEstanteRopa(@PathVariable Integer idRopa, @PathVariable Integer idEstante){
        Map<String, Object> mensaje = new HashMap<>();
        Optional<Producto> oRopa = service.findById(idRopa);
        if(!oRopa.isPresent()){
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("Ropa con id %d no existe", idRopa));
            return ResponseEntity.badRequest().body(mensaje);
        }

        Optional<Estante> oEstante = estanteDAO.findById(idEstante);
        if (!oEstante.isPresent()){
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("Estante con id %d no existe", idEstante));
            return ResponseEntity.badRequest().body(mensaje);
        }

        Producto ropa = oRopa.get();
        Estante estante = oEstante.get();

        ((Ropa)ropa).setEstante(estante);

        mensaje.put("datos", service.save(ropa));
        mensaje.put("succes", Boolean.TRUE);

        return ResponseEntity.ok(mensaje);
    }
}
