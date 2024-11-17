package org.atch.tb_grupo1.dto;

public class ObtenerPrendasMasVendidasPorMarcaDTO {
    private String nombre_marca;
    private String nombre_prenda;
    private int total_vendido;

    public String getNombre_marca() {
        return nombre_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }

    public String getNombre_prenda() {
        return nombre_prenda;
    }

    public void setNombre_prenda(String nombre_prenda) {
        this.nombre_prenda = nombre_prenda;
    }

    public int getTotal_vendido() {
        return total_vendido;
    }

    public void setTotal_vendido(int total_vendido) {
        this.total_vendido = total_vendido;
    }
}
