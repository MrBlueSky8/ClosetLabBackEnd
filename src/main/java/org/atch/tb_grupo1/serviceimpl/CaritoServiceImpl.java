package org.atch.tb_grupo1.serviceimpl;

import org.atch.tb_grupo1.entities.Carrito;
import org.atch.tb_grupo1.repositories.CarritoRepositorio;
import org.atch.tb_grupo1.services.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaritoServiceImpl implements CarritoService {
    @Autowired
    CarritoRepositorio repositorio;
    @Override
    public Carrito guardar(Carrito obj) {
        return repositorio.save(obj);
    }

    @Override
    public List<Carrito> listar() {
        return repositorio.findAll();
    }

    @Override
    public Carrito actualizar(Carrito obj) {
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
    public Carrito listId(int id) {
        return repositorio.findById(id).orElse(new Carrito());
    }
}
