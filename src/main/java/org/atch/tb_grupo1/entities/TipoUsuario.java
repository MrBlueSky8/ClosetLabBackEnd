package org.atch.tb_grupo1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoUsuario",uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "nombre"})})
public class TipoUsuario {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre",nullable = false,length =50)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario user;

    public TipoUsuario() {
    }

    public TipoUsuario(int id, String nombre, Usuario user) {
        this.id = id;
        this.nombre = nombre;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}