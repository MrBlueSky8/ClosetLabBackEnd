package org.atch.tb_grupo1.controller;

import org.atch.tb_grupo1.dto.TipoPrendaDTO;
import org.atch.tb_grupo1.entities.TipoPrenda;
import org.atch.tb_grupo1.services.TipoPrendaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CUSTOMER')")
public class TipoPrendaControlador {
    @Autowired
    TipoPrendaService service;
    @PostMapping("/tipo-prenda")
    public TipoPrendaDTO guardar(@RequestBody TipoPrendaDTO objDTO) {
        ModelMapper modelMapper = new ModelMapper();
        TipoPrenda obj=modelMapper.map(objDTO, TipoPrenda.class);
        obj=service.guardar(obj);
        return modelMapper.map(obj, TipoPrendaDTO.class);
    }

    @GetMapping("/tipo-prenda")
    public List<TipoPrenda> listar() {
        return service.listar();
    }

    @PutMapping("/tipo-prenda")
    public TipoPrendaDTO actualizar(@RequestBody TipoPrendaDTO objDTO) {
        ModelMapper modelMapper = new ModelMapper();
        TipoPrenda obj=modelMapper.map(objDTO, TipoPrenda.class);
        obj=service.actualizar(obj);
        return modelMapper.map(obj, TipoPrendaDTO.class);
    }

    @DeleteMapping("/tipo-prenda/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }

    @GetMapping("/tipo-prenda/{id}")
    public TipoPrendaDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        TipoPrendaDTO dto=m.map(service.listId(id),TipoPrendaDTO.class);
        return dto;
    }
}
