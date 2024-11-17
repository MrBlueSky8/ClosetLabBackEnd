package org.atch.tb_grupo1.controller;

import org.atch.tb_grupo1.dto.TipoUsuarioDTO;
import org.atch.tb_grupo1.entities.TipoUsuario;
import org.atch.tb_grupo1.services.TipoUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tipos_usuario")
public class TipoUsuarioControlador {
    @Autowired
    private TipoUsuarioService tuS;

    @PostMapping
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody TipoUsuarioDTO tiposDeUsuarioDTO) {
        ModelMapper d=new ModelMapper();
        TipoUsuario tiposDeUsuario = d.map(tiposDeUsuarioDTO,TipoUsuario.class);
        tuS.insert(tiposDeUsuario);
    }
    @PutMapping
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody TipoUsuarioDTO tiposDeUsuarioDTO) {
        ModelMapper d=new ModelMapper();
        TipoUsuario tiposDeUsuario = d.map(tiposDeUsuarioDTO,TipoUsuario.class);
        tuS.insert(tiposDeUsuario);
    }
    @GetMapping
    //@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public List<TipoUsuarioDTO> listar(){
        return tuS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,TipoUsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        tuS.delete(id);
    }
    @GetMapping("/{id}")
    public TipoUsuarioDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        TipoUsuarioDTO dto=m.map(tuS.listId(id),TipoUsuarioDTO.class);
        return dto;
    }

    @PutMapping("/eliminar")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity SetStockById(@RequestParam int id) {
        tuS.DeleteNativoByID(id);
        return ResponseEntity.ok("elemento eliminado correctamente.");
    }

}
