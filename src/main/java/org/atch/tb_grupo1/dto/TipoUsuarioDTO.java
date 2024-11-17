package org.atch.tb_grupo1.dto;


public class TipoUsuarioDTO {
    private int id;
    private String nombre;
    private UsuarioDTO user;

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

    public UsuarioDTO getUser() {
        return user;
    }

    public void setUser(UsuarioDTO user) {
        this.user = user;
    }
}
