package org.atch.tb_grupo1.serviceimpl;

import org.atch.tb_grupo1.entities.CarritoPrenda;
import org.atch.tb_grupo1.repositories.CarritoPrendaRepositorio;
import org.atch.tb_grupo1.services.CarritoPrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoPrendaServiceImpl implements CarritoPrendaService {
    @Autowired
    private CarritoPrendaRepositorio cpR;

    @Override
    public void insert(CarritoPrenda carritoPrenda) {
        cpR.save(carritoPrenda);
    }

    @Override
    public List<CarritoPrenda> list() {
        return cpR.findAll();
    }

    @Override
    public void delete(int id) {
        cpR.deleteById(id);
    }

    @Override
    public CarritoPrenda listId(int id) {
        return cpR.findById(id).orElse(new CarritoPrenda());
    }

    @Override
    public List<String[]> obtenerPrendasMasVendidasPorMarca() {
        return cpR.obtenerPrendasMasVendidasPorMarca();
    }
}
