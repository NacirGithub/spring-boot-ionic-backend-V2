package com.devprime.cursomc;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devprime.cursomc.domain.Categoria;
import com.devprime.cursomc.domain.Cidade;
import com.devprime.cursomc.domain.Estado;
import com.devprime.cursomc.domain.Produto;
import com.devprime.cursomc.repositories.CategoriaRepository;
import com.devprime.cursomc.repositories.CidadeRepository;
import com.devprime.cursomc.repositories.EstadoRepository;
import com.devprime.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "MacBook 2015", 100000.00);
		Produto p2 = new Produto(null, "Padtouch", 1000.00);
		Produto p3 = new Produto(null, "KeyBoard", 11000.00);
		
		

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat1.getProdutos().add(p1);
		
		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().add(cat1);
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		categoriaRepository.flush();
		produtoRepository.flush();
		
//		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
//		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Angola");
		Estado est2 = new Estado(null, "Moçambique");
		
		Cidade cid1 =  new Cidade(null, "Luanda", est1);
		Cidade cid2 =  new Cidade(null, "Maputo", est2);
		Cidade cid3 =  new Cidade(null, "Cabo Delgado ", est2);
		
		est1.getCidades().add(cid1);
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		
		
	}
}
