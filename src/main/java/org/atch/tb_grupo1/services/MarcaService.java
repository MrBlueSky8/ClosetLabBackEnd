package org.atch.tb_grupo1.services;

import org.atch.tb_grupo1.entities.EstadoCarrito;
import org.atch.tb_grupo1.entities.Marca;

import java.util.List;

public interface MarcaService {
    public Marca guardar(Marca obj);
    public List<Marca> listar();
    public Marca actualizar(Marca obj);
    public void eliminar(int id);
    public Marca listId(int id);
}
