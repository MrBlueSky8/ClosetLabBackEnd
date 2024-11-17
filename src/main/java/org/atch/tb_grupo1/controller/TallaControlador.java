package org.atch.tb_grupo1.controller;

import org.atch.tb_grupo1.dto.TallaDTO;
import org.atch.tb_grupo1.entities.Prenda;
import org.atch.tb_grupo1.entities.Talla;
import org.atch.tb_grupo1.services.TallaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CUSTOMER')")
public class TallaControlador {
    @Autowired
    TallaService service;
    @PostMapping("/talla")
    public TallaDTO guardar(@RequestBody TallaDTO objDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Talla obj=modelMapper.map(objDTO, Talla.class);
        obj=service.guardar(obj);
        return modelMapper.map(obj, TallaDTO.class);
    }

    @GetMapping("/talla")
    public List<Talla> listar() {
        return service.listar();
    }

    @PutMapping("/talla")
    public TallaDTO actualizar(@RequestBody TallaDTO objDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Talla obj=modelMapper.map(objDTO, Talla.class);
        obj=service.actualizar(obj);
        return modelMapper.map(obj, TallaDTO.class);
    }

    @DeleteMapping("/talla/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }

    @GetMapping("/talla/{id}")
    public TallaDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        TallaDTO dto=m.map(service.listId(id),TallaDTO.class);
        return dto;
    }
}
