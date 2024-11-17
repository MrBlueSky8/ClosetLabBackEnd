package org.atch.tb_grupo1.serviceimpl;

import org.atch.tb_grupo1.entities.Marca;
import org.atch.tb_grupo1.repositories.MarcaRepositorio;
import org.atch.tb_grupo1.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {
    @Autowired
    MarcaRepositorio repositorio;
    @Override
    public Marca guardar(Marca obj) {
        return repositorio.save(obj);
    }

    @Override
    public List<Marca> listar() {
        return repositorio.findAll();
    }

    @Override
    public Marca actualizar(Marca obj) {
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
    public Marca listId(int id) {
        return repositorio.findById(id).orElse(new Marca());
    }
}
