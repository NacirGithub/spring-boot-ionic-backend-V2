package com.devprime.cursomc;


import java.text.SimpleDateFormat;
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
import com.devprime.cursomc.domain.ItemPedido;
import com.devprime.cursomc.domain.Pagamento;
import com.devprime.cursomc.domain.PagamentoBoleto;
import com.devprime.cursomc.domain.PagamentoCartao;
import com.devprime.cursomc.domain.Pedido;
import com.devprime.cursomc.domain.Produto;
import com.devprime.cursomc.domain.enums.EstadoPagamento;
import com.devprime.cursomc.domain.enums.TipoCliente;
import com.devprime.cursomc.repositories.CategoriaRepository;
import com.devprime.cursomc.repositories.CidadeRepository;
import com.devprime.cursomc.repositories.ClienteRepository;
import com.devprime.cursomc.repositories.EnderecoRepository;
import com.devprime.cursomc.repositories.EstadoRepository;
import com.devprime.cursomc.repositories.ItemPedidoRepository;
import com.devprime.cursomc.repositories.PagamentoRepository;
import com.devprime.cursomc.repositories.PedidoRepository;
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
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Computador Pessoal");
		Categoria cat2 = new Categoria(null, "Macintosh");
		Categoria cat3 = new Categoria(null, "Smartphone");
		Categoria cat4 = new Categoria(null, "Jardinagem");
		Categoria cat5 = new Categoria(null, "AppleWatch");
		Categoria cat6 = new Categoria(null, "Decoracao");
		Categoria cat7 = new Categoria(null, " ");
		
		Produto p1 = new Produto(null, "MacBook 2015", 100000.00);
		Produto p2 = new Produto(null, "Padtouch", 1000.00);
		Produto p3 = new Produto(null, "KeyBoard", 11000.00);
		
		

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat1.getProdutos().add(p1);
		
		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().add(cat1);
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
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
		
		Cliente cli1 = new Cliente(null, "Nacir", "nacir@gmail.com", "84337834834", TipoCliente.PESSOAFISICA); 
		cli1.getTelefones().addAll(Arrays.asList("847993530", "827993530"));
		
//		Endereco e1 =  new Endereco(null, "Expansao-1", "540", "Apto 30", "Bairro das gordas","", cid3, cli1);
		
		Endereco e1 = new Endereco(null, "Expansao-1", "540", "Apto 30", "Bairro das gordas", "4753485734", cli1, cid3);
		Endereco e2 = new Endereco(null, "Av. 24 Julho", "540", "Apto 30", "Bairro das gordas", "4753485734", cli1, cid2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("27/08/2018 2:20"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("20/08/2018 14:00"), cli1, e2);
		
		Pagamento pag1 = new PagamentoCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pag1);
		
		Pagamento pag2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/08/2018 00:00"), null);
		ped2.setPagamento(pag2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pag1, pag2));
		
		ItemPedido itemPedido1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido itemPedido2 = new ItemPedido(ped1, p3, 0.00, 2, 200.00);
		ItemPedido itemPedido3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(itemPedido1, itemPedido2));
		ped2.getItens().addAll(Arrays.asList(itemPedido3));
		
		p1.getItens().addAll(Arrays.asList(itemPedido1));
		p2.getItens().addAll(Arrays.asList(itemPedido3));
		p3.getItens().addAll(Arrays.asList(itemPedido2));

		itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido3));
		
		

		
	}
}
