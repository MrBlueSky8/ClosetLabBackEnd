package org.atch.tb_grupo1.controller;

import org.atch.tb_grupo1.dto.FiltrarProductosPorTallaYMarcaDTO;
import org.atch.tb_grupo1.dto.ObtenerInventarioCriticoDTO;
import org.atch.tb_grupo1.dto.ObtenerReporteCalificacionesProductosDTO;
import org.atch.tb_grupo1.dto.PrendaDTO;
import org.atch.tb_grupo1.entities.Pago;
import org.atch.tb_grupo1.entities.Prenda;
import org.atch.tb_grupo1.services.PrendaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CUSTOMER')")
public class PrendaControlador {
    @Autowired
    PrendaService service;
    @PostMapping("/prenda")
    public PrendaDTO guardar(@RequestBody PrendaDTO objDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Prenda obj=modelMapper.map(objDTO, Prenda.class);
        obj=service.guardar(obj);
        return modelMapper.map(obj, PrendaDTO.class);
    }

    @GetMapping("/prenda")
    public List<Prenda> listar() {
        return service.listar();
    }

    @PutMapping("/prenda")
    public PrendaDTO actualizar(@RequestBody PrendaDTO objDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Prenda obj=modelMapper.map(objDTO, Prenda.class);
        obj=service.actualizar(obj);
        return modelMapper.map(obj, PrendaDTO.class);
    }

    @DeleteMapping("/prenda/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }

    @GetMapping("/prenda/{id}")
    public PrendaDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        PrendaDTO dto=m.map(service.listId(id),PrendaDTO.class);
        return dto;
    }

    @GetMapping("/prenda/getstock/{id}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public int GestStockByID(@PathVariable int id)
    {
        return service.GetStockByID(id);
    }

    @PutMapping("/prenda/setStockByid")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity SetStockById(@RequestParam int id, @RequestParam int stock) {
        service.SetStockByID(stock,id);
        return ResponseEntity.ok("Stock actualizado correctamente.");
    }

    @GetMapping("/prenda/obtenerinventariocritico")
    public List<ObtenerInventarioCriticoDTO> ObtenerInventarioCritico(){
        List<String[]> filaLista = service.obtenerInventarioCritico();
        List<ObtenerInventarioCriticoDTO> dtoLista=new ArrayList<>();
        for (String[] fila : filaLista){
            ObtenerInventarioCriticoDTO dto = new ObtenerInventarioCriticoDTO();
            dto.setPrenda_id(Integer.parseInt(fila[0]));
            dto.setNombre_prenda(fila[1]);
            dto.setDescripcion_prenda(fila[2]);
            dto.setMarca(fila[3]);
            dto.setCategoria(fila[4]);
            dto.setCantidad_en_stock(Integer.parseInt(fila[5]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
    @GetMapping("/prenda/filtrarportallaymarca")
    public List<FiltrarProductosPorTallaYMarcaDTO> FiltrarProductosPorTallaYMarca(@RequestParam int talla, @RequestParam int marca){
        List<String[]> filaLista = service.filtrarProductosPorTallaYMarca(talla, marca);
        List<FiltrarProductosPorTallaYMarcaDTO> dtoLista=new ArrayList<>();
        for (String[] fila : filaLista){
            FiltrarProductosPorTallaYMarcaDTO dto = new FiltrarProductosPorTallaYMarcaDTO();
            dto.setPrenda_id(Integer.parseInt(fila[0]));
            dto.setNombre_prenda(fila[1]);
            dto.setDescripcion_prenda(fila[2]);
            dto.setMarca(fila[3]);
            dto.setTalla(fila[4]);
            dto.setCategoria(fila[5]);
            dto.setCantidadEnStock(Integer.parseInt(fila[6]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/prenda/promediopuntajeporprenda")
    public List<ObtenerReporteCalificacionesProductosDTO> ObtenerReporteCalificacionesProductos(){
        List<String[]> filaLista = service.obtenerReporteCalificacionesProductos();
        List<ObtenerReporteCalificacionesProductosDTO> dtoLista=new ArrayList<>();
        for (String[] fila : filaLista){
            ObtenerReporteCalificacionesProductosDTO dto = new ObtenerReporteCalificacionesProductosDTO();
            dto.setPrenda_id(Integer.parseInt(fila[0]));
            dto.setNombre_prenda(fila[1]);
            dto.setDescripcion_prenda(fila[2]);
            dto.setMarca(fila[3]);
            dto.setCategoria(fila[4]);
            dto.setPromedio_calificacion(Float.parseFloat(fila[5]));
            dto.setComentarios(fila[6]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }

}
