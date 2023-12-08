package com.ventas.springboot.service.implementaciones;

import com.ventas.springboot.modelo.entidades.entity.Estante;
import com.ventas.springboot.modelo.entidades.entity.enumeradores.Vestimenta;
import com.ventas.springboot.repositorys.EstanteRepository;
import com.ventas.springboot.service.contratos.EstanteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class EstanteDAOImpl extends GenericoDAOImpl<Estante, EstanteRepository> implements EstanteDAO {

    @Autowired
    public EstanteDAOImpl(EstanteRepository repository){
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Estante> findEstantesByVestimenta(Vestimenta vestimenta){
        return repository.findEstantesByVestimenta(vestimenta);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Estante> findEstantesByBodegaNumero(String numero){
        return repository.findEstantesByBodegaNumero(numero);
    }

    @Override
    public Optional<Estante> findEstantesByNroEstante(Integer nroEstante){
        return repository.findEstantesByNroEstante(nroEstante);
    }
}
