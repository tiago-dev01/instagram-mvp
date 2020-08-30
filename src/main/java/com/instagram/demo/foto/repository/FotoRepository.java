package com.instagram.demo.foto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.instagram.demo.foto.model.Foto;

@Repository
public interface FotoRepository extends CrudRepository<Foto, Integer>{

	List<Foto> findByIdIn(List<Integer> fotosId);
}
