package com.instagram.demo.comentarios_foto.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.instagram.demo.comentarios_foto.model.ComentariosFoto;
import com.instagram.demo.comentarios_foto.model.ComentariosFotoDTO;
import com.instagram.demo.comentarios_foto.repository.ComentariosFotoRepository;
import com.instagram.demo.foto.model.Foto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComentariosFotoService {

	private final ComentariosFotoRepository repository;
	
	private final ObjectMapper objectMapper;
	
	public List<ComentariosFotoDTO> buscarComentariosFoto(Foto foto) {
		return repository.findByFoto(foto).stream().map(this::toDTO).collect(Collectors.toList());
	}

	public void atualizarCurtidas(Integer id) {
		Optional<ComentariosFoto> comentarioFoto = repository.findById(id);
		comentarioFoto.get().setCurtidas(comentarioFoto.get().getCurtidas()+1);
		repository.save(comentarioFoto.get());
	}
	
	public ComentariosFotoDTO toDTO(ComentariosFoto comentariosFoto) {
		String json = null;
		try {
			json = objectMapper.writeValueAsString(comentariosFoto);
			return objectMapper.readValue(json, ComentariosFotoDTO.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return ComentariosFotoDTO.builder().build();
	}

}
