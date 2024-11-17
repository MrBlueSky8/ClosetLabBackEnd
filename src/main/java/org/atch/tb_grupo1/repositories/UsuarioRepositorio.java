package org.atch.tb_grupo1.repositories;

import org.atch.tb_grupo1.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    public Usuario findByCorreo(String username);
    @Query(value = "select id from usuario where correo= :emailusr",nativeQuery = true)
    public int GetIdByEmail(String emailusr);

    @Query(value = "select id from usuario order by id desc limit 1", nativeQuery = true)
    public int ultimoidregistrado();
}
