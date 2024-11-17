package org.atch.tb_grupo1.services;

import org.atch.tb_grupo1.entities.Carrito;
import org.atch.tb_grupo1.entities.Categoria;

import java.util.List;

public interface CategoriaService {
    public Categoria guardar(Categoria obj);
    public List<Categoria> listar();
    public Categoria actualizar(Categoria obj);
    public void eliminar(int id);
    public Categoria listId(int id);
}
