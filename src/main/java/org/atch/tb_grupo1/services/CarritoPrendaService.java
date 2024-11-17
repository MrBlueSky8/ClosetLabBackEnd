package org.atch.tb_grupo1.services;

import org.atch.tb_grupo1.entities.CarritoPrenda;
import org.atch.tb_grupo1.entities.Categoria;

import java.util.List;

public interface CarritoPrendaService {
    public void insert(CarritoPrenda carritoPrenda);
    public List<CarritoPrenda> list();

    public void delete(int id);

    public CarritoPrenda listId(int id);
    public List<String[]> obtenerPrendasMasVendidasPorMarca();
}
