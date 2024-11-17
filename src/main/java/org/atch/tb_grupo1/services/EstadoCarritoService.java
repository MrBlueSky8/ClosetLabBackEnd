package org.atch.tb_grupo1.services;

import org.atch.tb_grupo1.entities.Categoria;
import org.atch.tb_grupo1.entities.EstadoCarrito;

import java.util.List;

public interface EstadoCarritoService {
    public EstadoCarrito guardar(EstadoCarrito obj);
    public List<EstadoCarrito> listar();
    public EstadoCarrito actualizar(EstadoCarrito obj);
    public void eliminar(int id);
    public EstadoCarrito listId(int id);
}
