package org.atch.tb_grupo1.repositories;

import jakarta.transaction.Transactional;
import org.atch.tb_grupo1.entities.Categoria;
import org.atch.tb_grupo1.entities.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrendaRepositorio extends JpaRepository<Prenda, Integer> {
    @Query(value = "select cantidad_en_stock from prenda where id= :prendaid",nativeQuery = true)
    public int GetStockByID(int prendaid);

    @Modifying
    @Transactional
    @Query(value = "UPDATE prenda\n" +
            "SET cantidad_en_stock = :nueva_cantidad\n" +
            "WHERE id = :prendaid",nativeQuery = true)
    public void SetStockByID(int nueva_cantidad, int prendaid);

    @Query(value = "SELECT \n" +
            "    pr.id AS prenda_id,\n" +
            "    pr.nombre AS nombre_prenda,\n" +
            "    pr.descipcion AS descripcion_prenda,\n" +
            "    m.nombre AS marca,\n" +
            "    cat.nombre AS categoria,\n" +
            "    pr.cantidad_en_stock AS cantidad_en_stock\n" +
            "FROM \n" +
            "    prenda pr\n" +
            "JOIN \n" +
            "    marca m ON pr.marca_id = m.id\n" +
            "JOIN \n" +
            "    categoria cat ON pr.categoria_id = cat.id\n" +
            "WHERE \n" +
            "    pr.cantidad_en_stock < 10\n" +
            "ORDER BY \n" +
            "    pr.cantidad_en_stock ASC", nativeQuery = true)
    public List<String[]> obtenerInventarioCritico();
    @Query(value = "SELECT \n" +
            "    pr.id AS prenda_id,\n" +
            "    pr.nombre AS nombre_prenda,\n" +
            "    pr.descipcion AS descripcion_prenda,\n" +
            "    m.nombre AS marca,\n" +
            "    t.nombre AS talla,\n" +
            "    cat.nombre AS categoria,\n" +
            "    pr.cantidad_en_stock AS cantidad_en_stock\n" +
            "FROM \n" +
            "    prenda pr\n" +
            "JOIN \n" +
            "    marca m ON pr.marca_id = m.id\n" +
            "JOIN \n" +
            "    talla t ON pr.talla_id = t.id\n" +
            "JOIN \n" +
            "    categoria cat ON pr.categoria_id = cat.id\n" +
            "WHERE \n" +
            "    pr.talla_id = :talla_id AND\n" +
            "    pr.marca_id = :marca_id\n" +
            "ORDER BY \n" +
            "    pr.nombre", nativeQuery = true)
    public List<String[]> filtrarProductosPorTallaYMarca(int talla_id, int marca_id);

    @Query(value = "SELECT \n" +
            "    pr.id AS prenda_id,\n" +
            "    pr.nombre AS nombre_prenda,\n" +
            "    pr.descipcion AS descripcion_prenda,\n" +
            "    m.nombre AS marca,\n" +
            "    cat.nombre AS categoria,\n" +
            "    AVG(rp.calificacion) AS promedio_calificacion,\n" +
            "    STRING_AGG(rp.comentario, '; ') AS comentarios\n" +
            "FROM \n" +
            "    prenda pr\n" +
            "JOIN \n" +
            "    reseña_prenda rp ON pr.id = rp.prenda_id\n" +
            "JOIN \n" +
            "    marca m ON pr.marca_id = m.id\n" +
            "JOIN \n" +
            "    categoria cat ON pr.categoria_id = cat.id\n" +
            "GROUP BY \n" +
            "    pr.id, pr.nombre, pr.descipcion, m.nombre, cat.nombre\n" +
            "ORDER BY \n" +
            "    promedio_calificacion ASC", nativeQuery = true)
    public List<String[]> obtenerReporteCalificacionesProductos();

}
