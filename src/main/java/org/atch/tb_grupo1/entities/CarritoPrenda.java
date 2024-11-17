package org.atch.tb_grupo1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CarritoPrenda")
public class CarritoPrenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcarrito_prenda;
    @ManyToOne
    @JoinColumn(name = "carrito_id")
    private Carrito carrito;

    @ManyToOne
    @JoinColumn(name = "prenda_id")
    private Prenda prenda;
    private int cantidad;

    public CarritoPrenda() {
    }

    public CarritoPrenda(int idcarrito_prenda, Carrito carrito, Prenda prenda, int cantidad) {
        this.idcarrito_prenda = idcarrito_prenda;
        this.carrito = carrito;
        this.prenda = prenda;
        this.cantidad = cantidad;
    }

    public int getIdcarrito_prenda() {
        return idcarrito_prenda;
    }

    public void setIdcarrito_prenda(int idcarrito_prenda) {
        this.idcarrito_prenda = idcarrito_prenda;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Prenda getPrenda() {
        return prenda;
    }

    public void setPrenda(Prenda prenda) {
        this.prenda = prenda;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}