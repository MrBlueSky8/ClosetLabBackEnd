package org.atch.tb_grupo1.repositories;

import org.atch.tb_grupo1.entities.Categoria;
import org.atch.tb_grupo1.entities.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepositorio extends JpaRepository<Pago, Integer> {
    @Query(value = "SELECT \n" +
            "    TO_CHAR(fecha_pago, 'Month') AS mes,\n" +
            "    SUM(monto_total) AS ingresos_mensuales\n" +
            "FROM \n" +
            "    pago\n" +
            "GROUP BY \n" +
            "    mes\n" +
            "ORDER BY \n" +
            "    MIN(fecha_pago)", nativeQuery = true)
    public List<String[]> obtenerIngresosMensuales();
    @Query(value = "SELECT\n" +
            "    p.fecha_pago AS fecha_compra,\n" +
            "    pr.nombre AS nombre_prenda,\n" +
            "    pr.descipcion AS descripcion_prenda,\n" +
            "    m.nombre AS marca,\n" +
            "    cat.nombre AS categoria,\n" +
            "    t.nombre AS talla,\n" +
            "    tp.nombre AS tipo_prenda,\n" +
            "    mp.nombre AS metodo_pago,\n" +
            "    p.monto_total AS total_pago\n" +
            "FROM\n" +
            "    pago p\n" +
            "JOIN\n" +
            "    carrito c ON p.carrito_id = c.id\n" +
            "JOIN\n" +
            "    carrito_prenda cp ON c.id = cp.carrito_id\n" +
            "JOIN\n" +
            "    prenda pr ON cp.prenda_id = pr.id\n" +
            "JOIN\n" +
            "    marca m ON pr.marca_id = m.id\n" +
            "JOIN\n" +
            "    categoria cat ON pr.categoria_id = cat.id\n" +
            "JOIN\n" +
            "    talla t ON pr.talla_id = t.id\n" +
            "JOIN\n" +
            "    tipo_prenda tp ON pr.tipo_id = tp.id\n" +
            "JOIN\n" +
            "    metodo_pago mp ON p.metodo_pago_id = mp.id\n" +
            "WHERE\n" +
            "    p.usuario_id = :usuario_id\n" +
            "ORDER BY\n" +
            "    p.fecha_pago DESC",nativeQuery = true)
    public List<String[]> obtenerHistorialComprasUsuario(int usuario_id);
    @Query(value = "SELECT \n" +
            "    TO_CHAR(p.fecha_pago, 'Month') AS mes,\n" +
            "    COUNT(DISTINCT p.usuario_id) AS clientes_activos\n" +
            "FROM \n" +
            "    pago p\n" +
            "GROUP BY \n" +
            "    mes, DATE_TRUNC('month', p.fecha_pago)\n" +
            "ORDER BY \n" +
            "    DATE_TRUNC('month', p.fecha_pago)", nativeQuery = true)
    public List<String[]> obtenerClientesActivosPorMes();

    @Query(value = "SELECT \n" +
            "    mp.nombre AS metodo_pago,\n" +
            "    COALESCE(COUNT(p.id), 0) AS frecuencia_uso\n" +
            "FROM \n" +
            "    metodo_pago mp\n" +
            "LEFT JOIN \n" +
            "    pago p ON p.metodo_pago_id = mp.id\n" +
            "GROUP BY \n" +
            "    mp.nombre\n" +
            "ORDER BY \n" +
            "    frecuencia_uso DESC", nativeQuery = true)
    public List<String[]> obtenerFrecuenciaMetodosPago();
}
