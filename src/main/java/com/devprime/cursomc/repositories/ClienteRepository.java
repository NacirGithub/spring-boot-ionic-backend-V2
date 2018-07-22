package com.devprime.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devprime.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
