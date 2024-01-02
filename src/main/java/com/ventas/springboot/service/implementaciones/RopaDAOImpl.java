package com.ventas.springboot.service.implementaciones;

import com.ventas.springboot.modelo.entidades.entity.Producto;
import com.ventas.springboot.modelo.entidades.entity.Ropa;
import com.ventas.springboot.modelo.entidades.entity.enumeradores.TipoRopa;
import com.ventas.springboot.repositorys.RopaRepository;
import com.ventas.springboot.service.contratos.RopaDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RopaDAOImpl extends ProductoDAOImpl implements RopaDAO {
    public RopaDAOImpl(@Qualifier("repositorioRopas")RopaRepository repository){
        super(repository);
    }

    @Override
    public Iterable<Producto> buscarRopasPorTipoRopa(TipoRopa tipoRopa){
        return ((RopaRepository)repository).buscarRopasPorTipoRopa(tipoRopa);
    }
}
