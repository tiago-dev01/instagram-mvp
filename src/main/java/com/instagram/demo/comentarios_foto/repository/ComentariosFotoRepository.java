package com.instagram.demo.comentarios_foto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.instagram.demo.comentarios_foto.model.ComentariosFoto;
import com.instagram.demo.foto.model.Foto;

@Repository
public interface ComentariosFotoRepository extends CrudRepository<ComentariosFoto, Integer>{

	List<ComentariosFoto> findByFoto(Foto foto);

}
