package org.atch.tb_grupo1.controller;

import org.atch.tb_grupo1.dto.ReseñaProbadorVirtualDTO;
import org.atch.tb_grupo1.entities.ReseñaProbadorVirtual;
import org.atch.tb_grupo1.services.ReseñaProbadorVirtualService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CUSTOMER')")
public class ReseñaProbadorVirtualController {
    @Autowired
    ReseñaProbadorVirtualService service;
    @PostMapping("/reseña-probador-virtual")
    public ReseñaProbadorVirtualDTO guardar(@RequestBody ReseñaProbadorVirtualDTO objDTO) {
        ModelMapper modelMapper = new ModelMapper();
        ReseñaProbadorVirtual obj=modelMapper.map(objDTO, ReseñaProbadorVirtual.class);
        obj=service.guardar(obj);
        return modelMapper.map(obj, ReseñaProbadorVirtualDTO.class);
    }

    @GetMapping("/reseñas-probador-virtual")
    public List<ReseñaProbadorVirtual> listar() {
        return service.listar();
    }

    @PutMapping("/reseña-probador-virtual")
    public ReseñaProbadorVirtualDTO actualizar(@RequestBody ReseñaProbadorVirtualDTO objDTO) {
        ModelMapper modelMapper = new ModelMapper();
        ReseñaProbadorVirtual obj=modelMapper.map(objDTO, ReseñaProbadorVirtual.class);
        obj=service.actualizar(obj);
        return modelMapper.map(obj, ReseñaProbadorVirtualDTO.class);
    }

    @DeleteMapping("/reseña-probador-virtual/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }
}
