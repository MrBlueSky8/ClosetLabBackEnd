package org.atch.tb_grupo1.serviceimpl;

import org.atch.tb_grupo1.entities.Usuario;
import org.atch.tb_grupo1.repositories.UsuarioRepositorio;
import org.atch.tb_grupo1.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired UsuarioRepositorio uR;

    @Override
    public void insert(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public Usuario listId(int id) {
        return uR.findById(id).orElse(new Usuario());
    }

    @Override
    public int GetIdByEmail(String emailusr) {
        return uR.GetIdByEmail(emailusr);
    }

    @Override
    public int ultimoidregistrado() {
        return uR.ultimoidregistrado();
    }
}
