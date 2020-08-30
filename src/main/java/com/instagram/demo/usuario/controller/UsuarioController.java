package com.instagram.demo.usuario.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instagram.demo.usuario.model.Usuario;
import com.instagram.demo.usuario.model.UsuarioFotosDTO;
import com.instagram.demo.usuario.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public List<Usuario> buscarTodos(){
		return usuarioService.buscarTodos();
	}
	
	@PostMapping
	public Usuario salvar(@RequestBody Usuario usuario) {
		return usuarioService.salvar(usuario);
	}
	
	@GetMapping("{id}/fotos")
	public UsuarioFotosDTO buscarFotosUsuario(@PathVariable(name = "id") Integer id){
		return usuarioService.buscarFotosUsuario(id);
	}
	
	@PatchMapping("{id}/fotos")
	public UsuarioFotosDTO vincularFotosUsuario(@PathVariable(name = "id") Integer id, @RequestBody List<Integer> fotosId){
		return usuarioService.vincularFotosUsuario(id, fotosId);
	}
}
