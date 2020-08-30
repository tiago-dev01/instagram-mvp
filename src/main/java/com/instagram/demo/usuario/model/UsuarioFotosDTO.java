package com.instagram.demo.usuario.model;

import java.util.Set;

import com.instagram.demo.foto.model.FotoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioFotosDTO {

	private UsuarioDTO usuario;
	
	private Set<FotoDTO> fotos;
}
