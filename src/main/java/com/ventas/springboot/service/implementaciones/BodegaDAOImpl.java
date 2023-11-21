package com.ventas.springboot.service.implementaciones;

import com.ventas.springboot.modelo.entidades.entity.Bodega;
import com.ventas.springboot.repositorys.BodegaRepository;
import com.ventas.springboot.service.contratos.BodegaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BodegaDAOImpl extends GenericoDAOImpl<Bodega, BodegaRepository> implements BodegaDAO {
    @Autowired
    public BodegaDAOImpl(BodegaRepository repository){
        super(repository);
    }

    @Override
    public Optional<Bodega> findBodegaByNumeroIgnoreCase(String nombre){
        return repository.findBodegaByNumeroIgnoreCase(nombre);
   }

   @Override
   public Iterable<Bodega> findBodegaByFechaEntradaBetween(LocalDateTime desde, LocalDateTime hasta){
        return repository.findBodegaByFechaEntradaBetween(desde, hasta);
    }
}
