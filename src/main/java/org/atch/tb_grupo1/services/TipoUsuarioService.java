package org.atch.tb_grupo1.services;

import org.atch.tb_grupo1.entities.TipoUsuario;

import java.util.List;

public interface TipoUsuarioService {
    public void insert(TipoUsuario tipos_de_usuario);
    public List<TipoUsuario> list();
    public void delete(int id);
    public TipoUsuario listId(int id);
    public void DeleteNativoByID(int id);
}
