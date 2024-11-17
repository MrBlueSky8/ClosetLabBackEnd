package org.atch.tb_grupo1.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.atch.tb_grupo1.entities.Carrito;
import org.atch.tb_grupo1.entities.MetodoPago;
import org.atch.tb_grupo1.entities.Usuario;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagoDTO {
    private int id;
    private MetodoPagoDTO metodoPago;
    private CarritoDTO carrito;
    private UsuarioDTO usuario;
    private float montoTotal;
    private Date fechaPago;
}
