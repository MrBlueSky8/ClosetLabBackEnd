package org.atch.tb_grupo1.dto;


public class CarritoPrendaDTO {
    private int idcarrito_prenda;
    private CarritoDTO carrito;
    private PrendaDTO prenda;
    private int cantidad;

    public int getIdcarrito_prenda() {
        return idcarrito_prenda;
    }

    public void setIdcarrito_prenda(int idcarrito_prenda) {
        this.idcarrito_prenda = idcarrito_prenda;
    }

    public CarritoDTO getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoDTO carrito) {
        this.carrito = carrito;
    }

    public PrendaDTO getPrenda() {
        return prenda;
    }

    public void setPrenda(PrendaDTO prenda) {
        this.prenda = prenda;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
