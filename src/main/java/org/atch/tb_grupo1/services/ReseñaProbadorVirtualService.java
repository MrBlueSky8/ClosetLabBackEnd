package org.atch.tb_grupo1.services;

import org.atch.tb_grupo1.entities.ReseñaProbadorVirtual;

import java.util.List;

public interface ReseñaProbadorVirtualService {
    public ReseñaProbadorVirtual guardar(ReseñaProbadorVirtual obj);
    public List<ReseñaProbadorVirtual> listar();
    public ReseñaProbadorVirtual actualizar(ReseñaProbadorVirtual obj);
    public void eliminar(int id);
}
