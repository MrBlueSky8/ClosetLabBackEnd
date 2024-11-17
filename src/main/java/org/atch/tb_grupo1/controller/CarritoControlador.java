package org.atch.tb_grupo1.controller;

import org.atch.tb_grupo1.dto.CarritoDTO;
import org.atch.tb_grupo1.entities.Carrito;
import org.atch.tb_grupo1.services.CarritoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CUSTOMER')")
public class CarritoControlador {
    @Autowired
    CarritoService service;
    @PostMapping("/carrito")
    public CarritoDTO guardar(@RequestBody CarritoDTO objDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Carrito obj=modelMapper.map(objDTO, Carrito.class);
        obj=service.guardar(obj);
        return modelMapper.map(obj, CarritoDTO.class);
    }

    @GetMapping("/carrito")
    public List<CarritoDTO> listar() {
        return service.listar().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,CarritoDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping("/carrito")
    public CarritoDTO actualizar(@RequestBody CarritoDTO objDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Carrito obj=modelMapper.map(objDTO, Carrito.class);
        obj=service.actualizar(obj);
        return modelMapper.map(obj, CarritoDTO.class);
    }

    @DeleteMapping("/carrito/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }

    @GetMapping("/carrito/{id}")
    public CarritoDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        CarritoDTO dto=m.map(service.listId(id),CarritoDTO.class);
        return dto;
    }
}
