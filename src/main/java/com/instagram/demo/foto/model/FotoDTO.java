package com.instagram.demo.foto.model;

import java.util.List;

import com.instagram.demo.comentarios_foto.model.ComentariosFotoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FotoDTO {

	private byte[] foto;
	
	private Integer curtidas;
	
	private List<ComentariosFotoDTO> comentariosFoto;
}
