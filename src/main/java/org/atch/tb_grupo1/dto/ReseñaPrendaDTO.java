package org.atch.tb_grupo1.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.atch.tb_grupo1.entities.Prenda;
import org.atch.tb_grupo1.entities.Usuario;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReseñaPrendaDTO {
    private int id;
    private PrendaDTO prenda;
    private UsuarioDTO usuario;
    private String comentario;
    private int calificacion;
}
