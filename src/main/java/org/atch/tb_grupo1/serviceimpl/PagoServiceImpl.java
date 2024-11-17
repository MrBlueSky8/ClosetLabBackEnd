package org.atch.tb_grupo1.serviceimpl;

import org.atch.tb_grupo1.entities.Pago;
import org.atch.tb_grupo1.repositories.PagoRepositorio;
import org.atch.tb_grupo1.services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoServiceImpl implements PagoService {
    @Autowired
    PagoRepositorio repositorio;
    @Override
    public Pago guardar(Pago obj) {
        return repositorio.save(obj);
    }

    @Override
    public List<Pago> listar() {
        return repositorio.findAll();
    }

    @Override
    public Pago actualizar(Pago obj) {
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
    public Pago listId(int id) {
        return repositorio.findById(id).orElse(new Pago());
    }

    @Override
    public List<String[]> obtenerIngresosMensuales() {
        return repositorio.obtenerIngresosMensuales();
    }

    @Override
    public List<String[]> obtenerHistorialComprasUsuario(int usuario_id) {
        return repositorio.obtenerHistorialComprasUsuario(usuario_id);
    }

    @Override
    public List<String[]> obtenerClientesActivosPorMes() {
        return repositorio.obtenerClientesActivosPorMes();
    }

    @Override
    public List<String[]> obtenerFrecuenciaMetodosPago() {
        return repositorio.obtenerFrecuenciaMetodosPago();
    }


}
