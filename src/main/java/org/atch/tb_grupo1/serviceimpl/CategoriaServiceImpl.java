package org.atch.tb_grupo1.serviceimpl;

import org.atch.tb_grupo1.entities.Categoria;
import org.atch.tb_grupo1.repositories.CategoriaRepositorio;
import org.atch.tb_grupo1.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    CategoriaRepositorio repositorio;
    @Override
    public Categoria guardar(Categoria obj) {
        return repositorio.save(obj);
    }

    @Override
    public List<Categoria> listar() {
        return repositorio.findAll();
    }

    @Override
    public Categoria actualizar(Categoria obj) {
        if(repositorio.existsById(obj.getId())){
            return repositorio.save(obj);
        }
        return null;
    }

    @Override
    public void eliminar(int id) {
        if(repositorio.existsById( id)){
            repositorio.deleteById(id);
        }
    }

    @Override
    public Categoria listId(int id) {
        return repositorio.findById(id).orElse(new Categoria());
    }
}
