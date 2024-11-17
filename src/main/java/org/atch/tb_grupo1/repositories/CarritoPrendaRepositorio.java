package org.atch.tb_grupo1.repositories;

import org.atch.tb_grupo1.entities.CarritoPrenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarritoPrendaRepositorio  extends JpaRepository<CarritoPrenda, Integer>{
    @Query(value = "SELECT \n" +
            "    m.nombre AS nombre_marca,\n" +
            "    pr.nombre AS nombre_prenda,\n" +
            "    SUM(cp.cantidad) AS total_vendido\n" +
            "FROM \n" +
            "    carrito_prenda cp\n" +
            "JOIN \n" +
            "    prenda pr ON cp.prenda_id = pr.id\n" +
            "JOIN \n" +
            "    marca m ON pr.marca_id = m.id\n" +
            "GROUP BY \n" +
            "    m.nombre, pr.nombre\n" +
            "ORDER BY \n" +
            "    m.nombre ASC,\n" +
            "    total_vendido DESC", nativeQuery = true)
    public List<String[]> obtenerPrendasMasVendidasPorMarca();
}
