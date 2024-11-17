package org.atch.tb_grupo1.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ObtenerHistorialComprasUsuarioDTO {
    private String fecha_compra;
    private String nombre_prenda;
    private String descripcion_prenda;
    private String marca;
    private String categoria;
    private String talla;
    private String tipo_prenda;
    private String metodo_pago;
    private float total_pago;

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getNombre_prenda() {
        return nombre_prenda;
    }

    public void setNombre_prenda(String nombre_prenda) {
        this.nombre_prenda = nombre_prenda;
    }

    public String getDescripcion_prenda() {
        return descripcion_prenda;
    }

    public void setDescripcion_prenda(String descripcion_prenda) {
        this.descripcion_prenda = descripcion_prenda;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getTipo_prenda() {
        return tipo_prenda;
    }

    public void setTipo_prenda(String tipo_prenda) {
        this.tipo_prenda = tipo_prenda;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public float getTotal_pago() {
        return total_pago;
    }

    public void setTotal_pago(float total_pago) {
        this.total_pago = total_pago;
    }
}
