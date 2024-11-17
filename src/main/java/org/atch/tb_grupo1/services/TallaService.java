package org.atch.tb_grupo1.services;

import org.atch.tb_grupo1.entities.Talla;

import java.util.List;

public interface TallaService {
    public Talla guardar(Talla obj);
    public List<Talla> listar();
    public Talla actualizar(Talla obj);
    public void eliminar(int id);
    public Talla listId(int id);
}
