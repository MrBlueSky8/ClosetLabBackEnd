package org.atch.tb_grupo1.repositories;

import org.atch.tb_grupo1.entities.TipoPrenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPrendaRepositorio extends JpaRepository<TipoPrenda, Integer> {
}
