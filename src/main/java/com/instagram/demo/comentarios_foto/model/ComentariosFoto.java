package com.instagram.demo.comentarios_foto.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.instagram.demo.foto.model.Foto;
import com.instagram.demo.usuario.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "comentarios_foto")
public class ComentariosFoto implements Serializable {

	private static final long serialVersionUID = -8318133616830060067L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "foto_id")
	private Foto foto;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	private String comentario;

	private Integer curtidas;

}
