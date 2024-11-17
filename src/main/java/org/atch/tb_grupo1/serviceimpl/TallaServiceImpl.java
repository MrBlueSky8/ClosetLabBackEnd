package org.atch.tb_grupo1.serviceimpl;

import org.atch.tb_grupo1.entities.Talla;
import org.atch.tb_grupo1.repositories.TallaRepositorio;
import org.atch.tb_grupo1.services.TallaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TallaServiceImpl implements TallaService {
    @Autowired
    TallaRepositorio repositorio;
    @Override
    public Talla guardar(Talla obj) {
        return repositorio.save(obj);
    }

    @Override
    public List<Talla> listar() {
        return repositorio.findAll();
    }

    @Override
    public Talla actualizar(Talla obj) {
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
    public Talla listId(int id) {
        return repositorio.findById(id).orElse(new Talla());
    }
}
