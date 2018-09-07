package com.devprime.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devprime.cursomc.domain.Categoria;
import com.devprime.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
//	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	@Transactional(readOnly=true)
	Page<Produto> findDistinctByNomeContainsAndCategoriasIn(
			String nome,  
			List<Categoria> categorias, Pageable pageRequest);
}
