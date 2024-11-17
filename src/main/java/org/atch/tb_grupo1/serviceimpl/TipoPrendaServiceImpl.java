package org.atch.tb_grupo1.serviceimpl;

import org.atch.tb_grupo1.entities.TipoPrenda;
import org.atch.tb_grupo1.repositories.TipoPrendaRepositorio;
import org.atch.tb_grupo1.services.TipoPrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPrendaServiceImpl implements TipoPrendaService {
    @Autowired
    TipoPrendaRepositorio repositorio;
    @Override
    public TipoPrenda guardar(TipoPrenda obj) {
        return repositorio.save(obj);
    }

    @Override
    public List<TipoPrenda> listar() {
        return repositorio.findAll();
    }

    @Override
    public TipoPrenda actualizar(TipoPrenda obj) {
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
    public TipoPrenda listId(int id) {
        return repositorio.findById(id).orElse(new TipoPrenda());
    }
}
