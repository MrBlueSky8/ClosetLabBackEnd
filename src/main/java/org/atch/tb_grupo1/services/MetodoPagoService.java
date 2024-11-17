package org.atch.tb_grupo1.services;


import org.atch.tb_grupo1.entities.Marca;
import org.atch.tb_grupo1.entities.MetodoPago;

import java.util.List;

public interface MetodoPagoService {
    public MetodoPago guardar(MetodoPago obj);
    public List<MetodoPago> listar();
    public MetodoPago actualizar(MetodoPago obj);
    public void eliminar(int id);
    public MetodoPago listId(int id);
}
