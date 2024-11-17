package org.atch.tb_grupo1.serviceimpl;

import org.atch.tb_grupo1.entities.TipoUsuario;
import org.atch.tb_grupo1.repositories.TipoUsuarioRepositorio;
import org.atch.tb_grupo1.services.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioServiceImpl  implements TipoUsuarioService {
    @Autowired TipoUsuarioRepositorio tuR;

    @Override
    public void insert(TipoUsuario tipos_de_usuario) {
        tuR.save(tipos_de_usuario);
    }

    @Override
    public List<TipoUsuario> list() {
        return tuR.findAll();
    }

    @Override
    public void delete(int id) {
        tuR.deleteById(id);
    }

    @Override
    public TipoUsuario listId(int id) {
        return tuR.findById(id).orElse(new TipoUsuario());
    }

    @Override
    public void DeleteNativoByID(int id) {
        tuR.DeleteNativoByID(id);
    }
}
