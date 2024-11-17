package org.atch.tb_grupo1.dto;

public class FiltrarProductosPorTallaYMarcaDTO {
    private int prenda_id;
    private String nombre_prenda;
    private String descripcion_prenda;
    private String marca;
    private String talla;
    private String categoria;
    private int cantidadEnStock;

    public int getPrenda_id() {
        return prenda_id;
    }

    public void setPrenda_id(int prenda_id) {
        this.prenda_id = prenda_id;
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

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }
}
