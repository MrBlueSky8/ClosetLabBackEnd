package org.atch.tb_grupo1.services;

import org.atch.tb_grupo1.entities.TipoPrenda;

import java.util.List;

public interface TipoPrendaService {
    public TipoPrenda guardar(TipoPrenda obj);
    public List<TipoPrenda> listar();
    public TipoPrenda actualizar(TipoPrenda obj);
    public void eliminar(int id);
    public TipoPrenda listId(int id);
}
