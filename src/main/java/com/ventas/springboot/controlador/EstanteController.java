package com.ventas.springboot.controlador;

import com.ventas.springboot.exeption.BadRequestException;
import com.ventas.springboot.modelo.entidades.entity.Estante;
import com.ventas.springboot.modelo.entidades.entity.enumeradores.Vestimenta;
import com.ventas.springboot.service.contratos.EstanteDAO;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;



@Deprecated
@RestController
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "false")
public class EstanteController extends GenericController<Estante, EstanteDAO>{

    public EstanteController(EstanteDAO service){
        super(service);
        numeroEntidades = "Estante";
    }

    @GetMapping("/searchVestimenta/{vestimenta}")
    public Iterable<Estante> EstantesByVestimenta(@PathVariable Vestimenta vestimenta){
        Iterable<Estante> oVestimenta = service.findEstantesByVestimenta(vestimenta);

        if (oVestimenta != null){
            return oVestimenta;
        }else {
            throw new BadRequestException("No se encontro la vestimenta");
        }

    }
}