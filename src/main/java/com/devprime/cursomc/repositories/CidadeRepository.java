package com.devprime.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devprime.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
