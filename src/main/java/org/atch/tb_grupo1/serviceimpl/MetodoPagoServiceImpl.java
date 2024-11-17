package org.atch.tb_grupo1.serviceimpl;

import org.atch.tb_grupo1.entities.MetodoPago;
import org.atch.tb_grupo1.repositories.MetodoPagoRepositorio;
import org.atch.tb_grupo1.services.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {
    @Autowired
    MetodoPagoRepositorio repositorio;
    @Override
    public MetodoPago guardar(MetodoPago obj) {
        return repositorio.save(obj);
    }

    @Override
    public List<MetodoPago> listar() {
        return repositorio.findAll();
    }

    @Override
    public MetodoPago actualizar(MetodoPago obj) {
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
    public MetodoPago listId(int id) {
        return repositorio.findById(id).orElse(new MetodoPago());
    }
}
