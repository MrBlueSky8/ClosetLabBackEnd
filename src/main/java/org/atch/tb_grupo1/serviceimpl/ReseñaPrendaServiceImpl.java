package org.atch.tb_grupo1.serviceimpl;

import org.atch.tb_grupo1.entities.ReseñaPrenda;
import org.atch.tb_grupo1.repositories.ReseñaPrendaRepositorio;
import org.atch.tb_grupo1.services.ReseñaPrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReseñaPrendaServiceImpl implements ReseñaPrendaService {
    @Autowired
    ReseñaPrendaRepositorio repositorio;
    @Override
    public ReseñaPrenda guardar(ReseñaPrenda obj) {
        return repositorio.save(obj);
    }

    @Override
    public List<ReseñaPrenda> listar() {
        return repositorio.findAll();
    }

    @Override
    public ReseñaPrenda actualizar(ReseñaPrenda obj) {
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
    public ReseñaPrenda listId(int id) {
        return repositorio.findById(id).orElse(new ReseñaPrenda());
    }

    @Override
    public List<String[]> obtenerReseñasDePrenda(int prenda_id) {
        return repositorio.obtenerReseñasDePrenda(prenda_id);
    }


}
