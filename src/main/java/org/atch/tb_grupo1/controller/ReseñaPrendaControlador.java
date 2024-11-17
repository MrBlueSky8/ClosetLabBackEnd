package org.atch.tb_grupo1.controller;

import org.atch.tb_grupo1.dto.ObtenerReseñasDePrendaDTO;
import org.atch.tb_grupo1.dto.ReseñaPrendaDTO;
import org.atch.tb_grupo1.entities.ReseñaPrenda;
import org.atch.tb_grupo1.services.ReseñaPrendaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CUSTOMER')")
public class ReseñaPrendaControlador {
    @Autowired
    ReseñaPrendaService service;
    @PostMapping("/reseña-prenda")
    public ReseñaPrendaDTO guardar(@RequestBody ReseñaPrendaDTO objDTO) {
        ModelMapper modelMapper = new ModelMapper();
        ReseñaPrenda obj=modelMapper.map(objDTO, ReseñaPrenda.class);
        obj=service.guardar(obj);
        return modelMapper.map(obj, ReseñaPrendaDTO.class);
    }

    @GetMapping("/reseña-prenda")
    public List<ReseñaPrendaDTO> listar() {
        return service.listar().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,ReseñaPrendaDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping("/reseña-prenda")
    public ReseñaPrendaDTO actualizar(@RequestBody ReseñaPrendaDTO objDTO) {
        ModelMapper modelMapper = new ModelMapper();
        ReseñaPrenda obj=modelMapper.map(objDTO, ReseñaPrenda.class);
        obj=service.actualizar(obj);
        return modelMapper.map(obj, ReseñaPrendaDTO.class);
    }

    @DeleteMapping("/reseña-prenda/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }

    @GetMapping("/reseña-prenda/{id}")
    public ReseñaPrendaDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        ReseñaPrendaDTO dto=m.map(service.listId(id),ReseñaPrendaDTO.class);
        return dto;
    }

    @GetMapping("/reseña-prenda/comentariosporprenda/{id}")
    public List<ObtenerReseñasDePrendaDTO> ObtenerReseñasDePrenda(@PathVariable int id){
        List<String[]> filaLista = service.obtenerReseñasDePrenda(id);
        List<ObtenerReseñasDePrendaDTO> dtoLista=new ArrayList<>();
        for (String[] fila : filaLista){
            ObtenerReseñasDePrendaDTO dto = new ObtenerReseñasDePrendaDTO();
            dto.setCalificacion(Float.parseFloat(fila[0]));
            dto.setComentario(fila[1]);
            dto.setNombre_usuario(fila[2]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
