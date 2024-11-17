package org.atch.tb_grupo1.services;


import org.atch.tb_grupo1.entities.ReseñaPrenda;

import java.util.List;

public interface ReseñaPrendaService {
    public ReseñaPrenda guardar(ReseñaPrenda obj);
    public List<ReseñaPrenda> listar();
    public ReseñaPrenda actualizar(ReseñaPrenda obj);
    public void eliminar(int id);
    public ReseñaPrenda listId(int id);
    public List<String[]> obtenerReseñasDePrenda(int prenda_id);
}
