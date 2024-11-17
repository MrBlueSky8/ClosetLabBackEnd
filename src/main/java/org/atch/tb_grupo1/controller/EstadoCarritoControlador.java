package org.atch.tb_grupo1.controller;

import org.atch.tb_grupo1.dto.EstadoCarritoDTO;
import org.atch.tb_grupo1.entities.Carrito;
import org.atch.tb_grupo1.entities.Categoria;
import org.atch.tb_grupo1.entities.EstadoCarrito;
import org.atch.tb_grupo1.services.EstadoCarritoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CUSTOMER')")
public class EstadoCarritoControlador {
    @Autowired
    EstadoCarritoService service;
    @PostMapping("/estado-carrito")
    public EstadoCarritoDTO guardar(@RequestBody EstadoCarritoDTO objDTO) {
        ModelMapper modelMapper = new ModelMapper();
        EstadoCarrito obj=modelMapper.map(objDTO, EstadoCarrito.class);
        obj=service.guardar(obj);
        return modelMapper.map(obj, EstadoCarritoDTO.class);
    }

    @GetMapping("/estado-carrito")
    public List<EstadoCarrito> listar() {
        return service.listar();
    }

    @PutMapping("/estado-carrito")
    public EstadoCarritoDTO actualizar(@RequestBody EstadoCarritoDTO objDTO) {
        ModelMapper modelMapper = new ModelMapper();
        EstadoCarrito obj=modelMapper.map(objDTO, EstadoCarrito.class);
        obj=service.actualizar(obj);
        return modelMapper.map(obj, EstadoCarritoDTO.class);
    }
    @DeleteMapping("/estado-carrito/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }

    @GetMapping("/estado-carrito/{id}")
    public EstadoCarritoDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        EstadoCarritoDTO dto=m.map(service.listId(id),EstadoCarritoDTO.class);
        return dto;
    }
}
