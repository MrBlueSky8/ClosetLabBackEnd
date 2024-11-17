package org.atch.tb_grupo1.repositories;

import org.atch.tb_grupo1.entities.ReseñaPrenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReseñaPrendaRepositorio extends JpaRepository<ReseñaPrenda, Integer> {
    @Query(value = "SELECT\n" +
            "    rp.calificacion,\n" +
            "    rp.comentario,\n" +
            "    u.nombre AS nombre_usuario\n" +
            "FROM\n" +
            "    reseña_prenda rp\n" +
            "JOIN\n" +
            "    usuario u ON rp.usuario_id = u.id\n" +
            "WHERE\n" +
            "    rp.prenda_id = :prenda_id\n" +
            "ORDER BY\n" +
            "    rp.id DESC", nativeQuery = true)
    public List<String[]> obtenerReseñasDePrenda(int prenda_id);
}
