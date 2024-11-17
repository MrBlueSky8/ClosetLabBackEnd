package org.atch.tb_grupo1.services;

import org.atch.tb_grupo1.entities.Categoria;
import org.atch.tb_grupo1.entities.Pago;
import org.atch.tb_grupo1.entities.Prenda;

import java.util.List;

public interface PrendaService {
    public Prenda guardar(Prenda obj);
    public List<Prenda> listar();
    public Prenda actualizar(Prenda obj);
    public void eliminar(int id);

    public Prenda listId(int id);

    public int GetStockByID(int prendaid);
    public void SetStockByID(int nueva_cantidad, int prendaid);
    public List<String[]> obtenerInventarioCritico();
    public List<String[]> filtrarProductosPorTallaYMarca(int talla_id, int marca_id);
    public List<String[]> obtenerReporteCalificacionesProductos();
}
