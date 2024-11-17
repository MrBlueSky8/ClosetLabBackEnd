package org.atch.tb_grupo1.repositories;

import org.atch.tb_grupo1.entities.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarritoRepositorio extends JpaRepository<Carrito, Integer> {
}
