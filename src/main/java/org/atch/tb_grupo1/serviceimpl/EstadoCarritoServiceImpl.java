package org.atch.tb_grupo1.serviceimpl;

import org.atch.tb_grupo1.entities.Categoria;
import org.atch.tb_grupo1.entities.EstadoCarrito;
import org.atch.tb_grupo1.repositories.EstadoCarritoRepositorio;
import org.atch.tb_grupo1.services.EstadoCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoCarritoServiceImpl implements EstadoCarritoService {
    @Autowired
    EstadoCarritoRepositorio repositorio;
    @Override
    public EstadoCarrito guardar(EstadoCarrito obj) {
        return repositorio.save(obj);
    }

    @Override
    public List<EstadoCarrito> listar() {
        return repositorio.findAll();
    }

    @Override
    public EstadoCarrito actualizar(EstadoCarrito obj) {
        if(repositorio.existsById(obj.getId())){
            return repositorio.save(obj);
        }
        return null;
    }

    @Override
    public void eliminar(int id) {
        if(repositorio.existsById(id)){
            repositorio.deleteById(id);
        }
    }

    @Override
    public EstadoCarrito listId(int id) {
        return repositorio.findById(id).orElse(new EstadoCarrito());
    }
}
