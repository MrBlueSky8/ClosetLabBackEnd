package org.atch.tb_grupo1.services;


import org.atch.tb_grupo1.entities.Carrito;

import java.util.List;

public interface CarritoService {
    public Carrito guardar(Carrito obj);
    public List<Carrito> listar();
    public Carrito actualizar(Carrito obj);
    public void eliminar(int id);
    public Carrito listId(int id);
}
