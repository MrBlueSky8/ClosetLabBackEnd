package org.atch.tb_grupo1.dto;

public class ObtenerReporteCalificacionesProductosDTO {
    private int prenda_id;
    private String nombre_prenda;
    private String descripcion_prenda;
    private String marca;
    private String categoria;
    private float promedio_calificacion;
    private String comentarios;

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPromedio_calificacion() {
        return promedio_calificacion;
    }

    public void setPromedio_calificacion(float promedio_calificacion) {
        this.promedio_calificacion = promedio_calificacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
