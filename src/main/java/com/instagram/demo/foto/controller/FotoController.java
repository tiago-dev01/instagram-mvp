package com.instagram.demo.foto.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instagram.demo.foto.model.Foto;
import com.instagram.demo.foto.service.FotoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("foto")
public class FotoController {

	private final FotoService service;

	@PostMapping
	public Foto salvar(@RequestBody Foto foto) {
		return service.salvar(foto);
	}

	@PatchMapping("{id}")
	public Foto atualizarCurtidas(@PathVariable(name = "id") Integer id) {
		return service.atualizarCurtidas(id);
	}
}
