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
    @Transactional(readOnly = true)
    public Iterable<Producto> findAll(){
        Iterable<Producto> productos = super.findAll();
        List<Producto> ropas = new ArrayList<>();
        for(Producto producto : productos){
            if(producto instanceof Ropa){
                ropas.add(producto);
            }
        }
        return ropas;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> findById(Integer id){
        Optional<Producto> optionalProducto = super.findById(id);
        Producto producto = optionalProducto.get();
        if(producto instanceof Ropa){
            return optionalProducto;
        }
        return null;
    }

    @Override
    public Iterable<Producto> buscarRopasPorTipoRopa(TipoRopa tipoRopa){
        return null;
    }
}
