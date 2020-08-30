package com.instagram.demo.comentarios_foto.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instagram.demo.comentarios_foto.service.ComentariosFotoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("comentario")
public class ComentariosFotoController {
 
	private final ComentariosFotoService service;
	
	@PatchMapping("{id}")
	public void atualizarCurtidas(@PathVariable(name = "id") Integer id) {
		service.atualizarCurtidas(id);
	}
}
