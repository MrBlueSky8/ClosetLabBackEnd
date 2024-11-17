package org.atch.tb_grupo1.serviceimpl;

import org.atch.tb_grupo1.entities.Categoria;
import org.atch.tb_grupo1.entities.Pago;
import org.atch.tb_grupo1.entities.Prenda;
import org.atch.tb_grupo1.repositories.PrendaRepositorio;
import org.atch.tb_grupo1.services.PrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaServiceImpl implements PrendaService {
    @Autowired
    PrendaRepositorio repositorio;
    @Override
    public Prenda guardar(Prenda obj) {
        return repositorio.save(obj);
    }

    @Override
    public List<Prenda> listar() {
        return repositorio.findAll();
    }

    @Override
    public Prenda actualizar(Prenda obj) {
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
    public Prenda listId(int id) {
        return repositorio.findById(id).orElse(new Prenda());
    }

    @Override
    public int GetStockByID(int prendaid) {
        return repositorio.GetStockByID(prendaid);
    }

    @Override
    public void SetStockByID(int nueva_cantidad, int prendaid) {
        repositorio.SetStockByID(nueva_cantidad,prendaid);
    }

    @Override
    public List<String[]> obtenerInventarioCritico() {
        return repositorio.obtenerInventarioCritico();
    }

    @Override
    public List<String[]> filtrarProductosPorTallaYMarca(int talla_id, int marca_id) {
        return repositorio.filtrarProductosPorTallaYMarca(talla_id,marca_id);
    }

    @Override
    public List<String[]> obtenerReporteCalificacionesProductos() {
        return repositorio.obtenerReporteCalificacionesProductos();
    }
}
