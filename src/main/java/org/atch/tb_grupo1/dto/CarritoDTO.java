package org.atch.tb_grupo1.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.atch.tb_grupo1.entities.EstadoCarrito;
import org.atch.tb_grupo1.entities.Usuario;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarritoDTO {
    private Integer id;
    private EstadoCarritoDTO estadoCarrito;
    private UsuarioDTO usuario;
}
