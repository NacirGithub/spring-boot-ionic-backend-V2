package com.devprime.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devprime.cursomc.domain.Categoria;
import com.devprime.cursomc.repositories.CategoriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo; 
	
	public Categoria find(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objecto nao encontrado! id: " + id + ",  Tipo: " + Categoria.class.getName()));
	} 

	public Categoria save(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}
