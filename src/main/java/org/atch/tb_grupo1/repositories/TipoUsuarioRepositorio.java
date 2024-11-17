package org.atch.tb_grupo1.repositories;

import jakarta.transaction.Transactional;
import org.atch.tb_grupo1.entities.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoUsuarioRepositorio  extends JpaRepository<TipoUsuario, Integer> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tipo_usuario WHERE id = :id",nativeQuery = true)
    public void DeleteNativoByID(int id);
}
