package com.devprime.cursomc;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devprime.cursomc.domain.Categoria;
import com.devprime.cursomc.domain.Cidade;
import com.devprime.cursomc.domain.Cliente;
import com.devprime.cursomc.domain.Endereco;
import com.devprime.cursomc.domain.Estado;
import com.devprime.cursomc.domain.Produto;
import com.devprime.cursomc.domain.enums.TipoCliente;
import com.devprime.cursomc.repositories.CategoriaRepository;
import com.devprime.cursomc.repositories.CidadeRepository;
import com.devprime.cursomc.repositories.ClienteRepository;
import com.devprime.cursomc.repositories.EnderecoRepository;
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
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
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
		
		Cliente cli1 = new Cliente(null, "Una Nacir", "una.nacir@gmail.com", "84337834834", TipoCliente.PESSOAFISICA); 
		cli1.getTelefones().addAll(Arrays.asList("847993530", "827993530"));
		
//		Endereco e1 =  new Endereco(null, "Expansao-1", "540", "Apto 30", "Bairro das gordas","", cid3, cli1);
		
		Endereco e1 = new Endereco(null, "Expansao-1", "540", "Apto 30", "Bairro das gordas", "4753485734", cli1, cid3);
		Endereco e2 = new Endereco(null, "Av. 24 Julho", "540", "Apto 30", "Bairro das gordas", "4753485734", cli1, cid2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		
	}
}
