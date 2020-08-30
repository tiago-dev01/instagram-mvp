package com.instagram.demo.foto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.instagram.demo.comentarios_foto.model.ComentariosFotoDTO;
import com.instagram.demo.comentarios_foto.service.ComentariosFotoService;
import com.instagram.demo.foto.model.Foto;
import com.instagram.demo.foto.model.FotoDTO;
import com.instagram.demo.foto.repository.FotoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FotoService {

	private final FotoRepository repository;
	
	private final ComentariosFotoService comentariosFotoService;

	private final ObjectMapper objectMapper;

	public Foto salvar(Foto foto) {
		return repository.save(foto);
	}

	public Foto atualizarCurtidas(Integer id) {
		Optional<Foto> buscarFoto = repository.findById(id);
		buscarFoto.get().setCurtidas(buscarFoto.get().getCurtidas()+1);
		return repository.save(buscarFoto.get());
	}

	public List<Foto> buscarFotosPor(List<Integer> fotosId) {
		return repository.findByIdIn(fotosId);
	}

	public FotoDTO toDTO(Foto foto) {
		String json = null;
		List<ComentariosFotoDTO> buscarComentariosFoto = comentariosFotoService.buscarComentariosFoto(foto);	
		try {
			json = objectMapper.writeValueAsString(foto);
			FotoDTO dto = objectMapper.readValue(json, FotoDTO.class);
			dto.setComentariosFoto(buscarComentariosFoto);
			return dto;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return FotoDTO.builder().build();
	}
}
