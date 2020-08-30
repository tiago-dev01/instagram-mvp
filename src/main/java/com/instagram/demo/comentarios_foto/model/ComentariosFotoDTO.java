package com.instagram.demo.comentarios_foto.model;

import com.instagram.demo.usuario.model.UsuarioDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ComentariosFotoDTO {

	private UsuarioDTO usuario;
	
	private String comentario;
	
	private Integer curtidas;
}
