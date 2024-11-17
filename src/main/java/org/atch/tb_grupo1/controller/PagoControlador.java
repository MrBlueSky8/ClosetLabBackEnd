package org.atch.tb_grupo1.controller;

import org.atch.tb_grupo1.dto.*;
import org.atch.tb_grupo1.entities.Carrito;
import org.atch.tb_grupo1.entities.Pago;
import org.atch.tb_grupo1.services.PagoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CUSTOMER')")
public class PagoControlador {
    @Autowired
    PagoService service;
    @PostMapping("/pago")
    public PagoDTO guardar(@RequestBody PagoDTO objDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Pago obj=modelMapper.map(objDTO, Pago.class);
        obj=service.guardar(obj);
        return modelMapper.map(obj, PagoDTO.class);
    }

    @GetMapping("/pago")
    public List<PagoDTO> listar() {
        return service.listar().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,PagoDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping("/pago")
    public PagoDTO actualizar(@RequestBody PagoDTO objDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Pago obj=modelMapper.map(objDTO, Pago.class);
        obj=service.actualizar(obj);
        return modelMapper.map(obj, PagoDTO.class);
    }

    @DeleteMapping("/pago/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }

    @GetMapping("/pago/{id}")
    public PagoDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        PagoDTO dto=m.map(service.listId(id),PagoDTO.class);
        return dto;
    }

    @GetMapping("/pago/ingresosmensuales")
    public List<ObtenerIngresosMensualesDTO> ingresosmensuales(){
        List<String[]> filaLista = service.obtenerIngresosMensuales();
        List<ObtenerIngresosMensualesDTO> dtoLista=new ArrayList<>();
        for (String[] fila : filaLista){
            ObtenerIngresosMensualesDTO dto = new ObtenerIngresosMensualesDTO();
            dto.setMes(fila[0]);
            dto.setIngresos_mensuales(Float.parseFloat(fila[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/pago/HistorialComprasUsuario/{id}")
    public List<ObtenerHistorialComprasUsuarioDTO> ObtenerHistorialComprasUsuario(@PathVariable("id") Integer id){
        List<String[]> filaLista = service.obtenerHistorialComprasUsuario(id);
        List<ObtenerHistorialComprasUsuarioDTO> dtoLista=new ArrayList<>();
        for (String[] fila : filaLista){
            ObtenerHistorialComprasUsuarioDTO dto = new ObtenerHistorialComprasUsuarioDTO();
            dto.setFecha_compra(fila[0]);
            dto.setNombre_prenda(fila[1]);
            dto.setDescripcion_prenda(fila[2]);
            dto.setMarca(fila[3]);
            dto.setCategoria(fila[4]);
            dto.setTalla(fila[5]);
            dto.setTipo_prenda(fila[6]);
            dto.setMetodo_pago(fila[7]);
            dto.setTotal_pago(Float.parseFloat(fila[8]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/pago/obtenerclientesactivospormes")
    public List<ObtenerClientesActivosPorMesDTO> ObtenerClientesActivosPorMes(){
        List<String[]> filaLista = service.obtenerClientesActivosPorMes();
        List<ObtenerClientesActivosPorMesDTO> dtoLista=new ArrayList<>();
        for (String[] fila : filaLista){
            ObtenerClientesActivosPorMesDTO dto = new ObtenerClientesActivosPorMesDTO();
            dto.setMes(fila[0]);
            dto.setClientes_activos(Integer.parseInt(fila[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/pago/frecuenciametodospago")
    public List<ObtenerFrecuenciaMetodosPagoDTO> ObtenerFrecuenciaMetodosPago(){
        List<String[]> filaLista = service.obtenerFrecuenciaMetodosPago();
        List<ObtenerFrecuenciaMetodosPagoDTO> dtoLista=new ArrayList<>();
        for (String[] fila : filaLista){
            ObtenerFrecuenciaMetodosPagoDTO dto = new ObtenerFrecuenciaMetodosPagoDTO();
            dto.setMetodo_pago(fila[0]);
            dto.setFrecuencia_uso(Integer.parseInt(fila[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
