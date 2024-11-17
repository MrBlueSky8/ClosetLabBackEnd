package org.atch.tb_grupo1.repositories;

import org.atch.tb_grupo1.entities.Categoria;
import org.atch.tb_grupo1.entities.EstadoCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCarritoRepositorio extends JpaRepository<EstadoCarrito, Integer> {
}
