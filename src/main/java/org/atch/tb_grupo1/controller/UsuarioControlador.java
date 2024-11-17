package org.atch.tb_grupo1.controller;

import org.atch.tb_grupo1.dto.UsuarioDTO;
import org.atch.tb_grupo1.entities.TipoUsuario;
import org.atch.tb_grupo1.entities.Usuario;
import org.atch.tb_grupo1.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlador {
    @Autowired
    UsuarioService uS;

    @PostMapping
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper d=new ModelMapper();
        Usuario usuario = d.map(usuarioDTO, Usuario.class);
        uS.insert(usuario);
    }

    @PutMapping
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper d=new ModelMapper();
        Usuario usuario = d.map(usuarioDTO, Usuario.class);
        uS.insert(usuario);
    }

    @GetMapping
    //@PreAuthorize("hasAuthority('ADMIN')")
    public List<UsuarioDTO> listar(){
        return uS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        uS.delete(id);
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public UsuarioDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        UsuarioDTO dto=m.map(uS.listId(id),UsuarioDTO.class);
        return dto;
    }

    @GetMapping("/findidbyemail")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public int FindIdByEmail(@RequestParam String email)
    {
        return uS.GetIdByEmail(email);
    }

    @GetMapping("/ultimoidregistrado")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public int UltimoIdRegistrado()
    {
        return uS.ultimoidregistrado();
    }
}
