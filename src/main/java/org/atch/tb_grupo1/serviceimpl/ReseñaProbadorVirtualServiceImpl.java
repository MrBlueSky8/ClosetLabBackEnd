package org.atch.tb_grupo1.serviceimpl;

import org.atch.tb_grupo1.entities.ReseñaProbadorVirtual;
import org.atch.tb_grupo1.repositories.ReseñaProbadorVirtualRepository;
import org.atch.tb_grupo1.services.ReseñaProbadorVirtualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReseñaProbadorVirtualServiceImpl implements ReseñaProbadorVirtualService {
    @Autowired
    ReseñaProbadorVirtualRepository repository;
    @Override
    public ReseñaProbadorVirtual guardar(ReseñaProbadorVirtual obj) {
        return repository.save(obj);
    }

    @Override
    public List<ReseñaProbadorVirtual> listar() {
        return repository.findAll();
    }

    @Override
    public ReseñaProbadorVirtual actualizar(ReseñaProbadorVirtual obj) {
        if(repository.existsById(obj.getId())) {
            return repository.save(obj);
        }
        return null;
    }

    @Override
    public void eliminar(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
