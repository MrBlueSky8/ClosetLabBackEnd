package org.atch.tb_grupo1.controller;

import org.atch.tb_grupo1.dto.CarritoPrendaDTO;
import org.atch.tb_grupo1.dto.ObtenerPrendasMasVendidasPorMarcaDTO;
import org.atch.tb_grupo1.entities.Carrito;
import org.atch.tb_grupo1.entities.CarritoPrenda;
import org.atch.tb_grupo1.services.CarritoPrendaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/carritoPrenda")
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CUSTOMER')")
public class CarritoPrendaControlador {
    @Autowired
    CarritoPrendaService carritoPrendaService;

    @PostMapping
    public void insertar(@RequestBody CarritoPrendaDTO carritoPrendaDTO) {
        ModelMapper d=new ModelMapper();
        CarritoPrenda carritoPrenda = d.map(carritoPrendaDTO,CarritoPrenda.class);
        carritoPrendaService.insert(carritoPrenda);
    }

    @PutMapping
    public void modificar(@RequestBody CarritoPrendaDTO carritoPrendaDTO) {
        ModelMapper d=new ModelMapper();
        CarritoPrenda carritoPrenda = d.map(carritoPrendaDTO,CarritoPrenda.class);
        carritoPrendaService.insert(carritoPrenda);
    }

    @GetMapping
    public List<CarritoPrendaDTO> listar(){
        return carritoPrendaService.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,CarritoPrendaDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        carritoPrendaService.delete(id);
    }

    @GetMapping("/{id}")
    public CarritoPrendaDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        CarritoPrendaDTO dto=m.map(carritoPrendaService.listId(id),CarritoPrendaDTO.class);
        return dto;
    }

    @GetMapping("/prendasmasvendidas")
    public List<ObtenerPrendasMasVendidasPorMarcaDTO> ObtenerPrendasMasVendidasPorMarca(){
        List<String[]> filaLista = carritoPrendaService.obtenerPrendasMasVendidasPorMarca();
        List<ObtenerPrendasMasVendidasPorMarcaDTO> dtoLista=new ArrayList<>();
        for (String[] fila : filaLista){
            ObtenerPrendasMasVendidasPorMarcaDTO dto = new ObtenerPrendasMasVendidasPorMarcaDTO();
            dto.setNombre_marca(fila[0]);
            dto.setNombre_prenda(fila[1]);
            dto.setTotal_vendido(Integer.parseInt(fila[2]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

}
