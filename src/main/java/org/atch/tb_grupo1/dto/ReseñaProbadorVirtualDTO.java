package org.atch.tb_grupo1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.atch.tb_grupo1.entities.Usuario;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReseñaProbadorVirtualDTO {
    private int id;
    private UsuarioDTO usuario;
    private String comentario;
    private int calificacion;
}
