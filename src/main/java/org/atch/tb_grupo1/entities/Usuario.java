package org.atch.tb_grupo1.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dni", nullable = false, length = 50)
    private String dni;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<TipoUsuario> roles;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;
    @Column(name = "correo", nullable = false, length = 250)
    private String correo;
    @Column(name = "contra", nullable = false, length = 500)
    private String contra;
    @Column(name = "telefono", nullable = false, length = 50)
    private String telefono;
    private Boolean enabled;

    public Usuario() {
    }

    public Usuario(int id, String dni, List<TipoUsuario> roles, String nombre, String correo, String contra, String telefono, Boolean enabled) {
        this.id = id;
        this.dni = dni;
        this.roles = roles;
        this.nombre = nombre;
        this.correo = correo;
        this.contra = contra;
        this.telefono = telefono;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<TipoUsuario> getRoles() {
        return roles;
    }

    public void setRoles(List<TipoUsuario> roles) {
        this.roles = roles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}