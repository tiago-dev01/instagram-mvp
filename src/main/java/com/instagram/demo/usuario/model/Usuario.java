package com.instagram.demo.usuario.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.instagram.demo.foto.model.Foto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "usuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -1839439733818051474L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 100, unique = true)
	private String login;

	@Column(length = 40)
	private String senha;

	@Column(name = "nome_usuario", length = 100, unique = true)
	private String nomeUsuario;

	@Lob
	private byte[] foto;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="usuario_fotos",
             joinColumns={@JoinColumn(name="usuario_id")},
             inverseJoinColumns={@JoinColumn(name="foto_id")})
	Set<Foto> fotos = new HashSet<>();
}
