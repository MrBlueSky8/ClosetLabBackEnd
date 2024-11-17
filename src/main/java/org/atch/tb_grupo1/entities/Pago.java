package org.atch.tb_grupo1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "metodo_pago_id")
    private MetodoPago metodoPago;

    @ManyToOne()
    @JoinColumn(name = "carrito_id")
    private Carrito carrito;

    @ManyToOne()
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private float montoTotal;

    private Date fechaPago;

}