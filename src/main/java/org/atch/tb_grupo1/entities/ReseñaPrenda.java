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
public class ReseñaPrenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "prenda_id")
    private Prenda prenda;

    @ManyToOne()
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String comentario;

    private int calificacion;
}