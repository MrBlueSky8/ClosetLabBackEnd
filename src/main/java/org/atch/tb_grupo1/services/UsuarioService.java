package org.atch.tb_grupo1.services;

import org.atch.tb_grupo1.entities.TipoUsuario;
import org.atch.tb_grupo1.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    public void insert(Usuario usuario);
    public List<Usuario> list();

    public void delete(int id);

    public Usuario listId(int id);
    public int GetIdByEmail(String emailusr);
    public int ultimoidregistrado();

}
