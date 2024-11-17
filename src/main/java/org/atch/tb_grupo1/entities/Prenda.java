package org.atch.tb_grupo1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Prenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String descipcion;

    @ManyToOne()
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @ManyToOne()
    @JoinColumn(name = "talla_id")
    private Talla talla;

    @ManyToOne()
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne()
    @JoinColumn(name = "tipo_id")
    private TipoPrenda tipo;

    private int cantidadEnStock;

}