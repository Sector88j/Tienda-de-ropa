package com.ventas.springboot.controlador;

import com.ventas.springboot.exeption.BadRequestException;
import com.ventas.springboot.service.contratos.GenericoDAO;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class GenericController <E, S extends GenericoDAO<E>>{
    protected final S service;
    protected String numeroEntidades;

    public GenericController(S service){
        this.service = service;
    }

    @GetMapping
    public List<E> obtenerTodos(){
        List<E> listado = (List<E>) service.findAll();
        if(listado.isEmpty()){
            throw new BadRequestException(String.format("No se han encontrado %ss",
                    numeroEntidades));
        }
        return listado;
    }
}
