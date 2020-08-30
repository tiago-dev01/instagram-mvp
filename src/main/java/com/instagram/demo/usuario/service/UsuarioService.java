package com.instagram.demo.usuario.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.instagram.demo.foto.model.Foto;
import com.instagram.demo.foto.model.FotoDTO;
import com.instagram.demo.foto.service.FotoService;
import com.instagram.demo.usuario.model.Usuario;
import com.instagram.demo.usuario.model.UsuarioDTO;
import com.instagram.demo.usuario.model.UsuarioFotosDTO;
import com.instagram.demo.usuario.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuarioService {

	private final UsuarioRepository repository;

	private final FotoService fotoService;

	private final ObjectMapper objectMapper;

	public List<Usuario> buscarTodos() {
		return (List<Usuario>) repository.findAll();
	}

	public Usuario salvar(Usuario usuario) {
		return repository.save(usuario);
	}

	public UsuarioFotosDTO vincularFotosUsuario(Integer id, List<Integer> fotosId) {
		Usuario usuario = repository.findById(id).orElseThrow();
		Set<Foto> fotosUsuario = fotoService.buscarFotosPor(fotosId).stream().collect(Collectors.toSet());
		usuario.getFotos().addAll(fotosUsuario);
		Set<FotoDTO> fotoDTO = fotosUsuario.stream().map(foto -> fotoService.toDTO(foto)).collect(Collectors.toSet());
		repository.save(usuario);
		return UsuarioFotosDTO.builder().fotos(fotoDTO).usuario(toDTO(usuario)).build();
	}

	public UsuarioFotosDTO buscarFotosUsuario(Integer id) {
		Optional<Usuario> usuario = repository.findById(id);
		Set<FotoDTO> fotosUsuario = usuario.get().getFotos().stream().map(foto -> fotoService.toDTO(foto))
				.collect(Collectors.toSet());
		return UsuarioFotosDTO.builder().fotos(fotosUsuario).usuario(toDTO(usuario.get())).build();
	}

	public UsuarioDTO toDTO(Usuario usuario) {
		String json = null;
		try {
			json = objectMapper.writeValueAsString(usuario);
			return objectMapper.readValue(json, UsuarioDTO.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return UsuarioDTO.builder().build();
	}
}
