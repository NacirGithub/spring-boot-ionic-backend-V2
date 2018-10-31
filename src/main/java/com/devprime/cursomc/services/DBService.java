package com.devprime.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
import com.devprime.cursomc.domain.enums.Perfil;
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

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pwdEncoder;

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

	public void instantiateTestDatabase() throws ParseException {
		Categoria cat1 = new Categoria(null, "Computador Pessoal");
		Categoria cat2 = new Categoria(null, "Macintosh");
		Categoria cat3 = new Categoria(null, "Smartphone");
		Categoria cat4 = new Categoria(null, "Jardinagem");
		Categoria cat5 = new Categoria(null, "AppleWatch");
		Categoria cat6 = new Categoria(null, "Decoracao");
		Categoria cat7 = new Categoria(null, "Florista");

		Produto p1 = new Produto(null, "MacBook 2015", 100000.00);
		Produto p2 = new Produto(null, "Padtouch", 1000.00);
		Produto p3 = new Produto(null, "KeyBoard", 11000.00);

		Produto p12 = new Produto(null, "Produto 12", 10.00);
		Produto p13 = new Produto(null, "Produto 13", 10.00);
		Produto p14 = new Produto(null, "Produto 14", 10.00);
		Produto p15 = new Produto(null, "Produto 15", 10.00);
		Produto p16 = new Produto(null, "Produto 16", 10.00);
		Produto p17 = new Produto(null, "Produto 17", 10.00);
		Produto p18 = new Produto(null, "Produto 18", 10.00);
		Produto p19 = new Produto(null, "Produto 19", 10.00);
		Produto p20 = new Produto(null, "Produto 20", 10.00);
		Produto p21 = new Produto(null, "Produto 21", 10.00);
		Produto p22 = new Produto(null, "Produto 22", 10.00);
		Produto p23 = new Produto(null, "Produto 23", 10.00);
		Produto p24 = new Produto(null, "Produto 24", 10.00);
		Produto p25 = new Produto(null, "Produto 25", 10.00);
		Produto p26 = new Produto(null, "Produto 26", 10.00);
		Produto p27 = new Produto(null, "Produto 27", 10.00);
		Produto p28 = new Produto(null, "Produto 28", 10.00);
		Produto p29 = new Produto(null, "Produto 29", 10.00);
		Produto p30 = new Produto(null, "Produto 30", 10.00);
		Produto p31 = new Produto(null, "Produto 31", 10.00);
		Produto p32 = new Produto(null, "Produto 32", 10.00);
		Produto p33 = new Produto(null, "Produto 33", 10.00);
		Produto p34 = new Produto(null, "Produto 34", 10.00);
		Produto p35 = new Produto(null, "Produto 35", 10.00);
		Produto p36 = new Produto(null, "Produto 36", 10.00);
		Produto p37 = new Produto(null, "Produto 37", 10.00);
		Produto p38 = new Produto(null, "Produto 38", 10.00);
		Produto p39 = new Produto(null, "Produto 39", 10.00);
		Produto p40 = new Produto(null, "Produto 40", 10.00);
		Produto p41 = new Produto(null, "Produto 41", 10.00);
		Produto p42 = new Produto(null, "Produto 42", 10.00);
		Produto p43 = new Produto(null, "Produto 43", 10.00);
		Produto p44 = new Produto(null, "Produto 44", 10.00);
		Produto p45 = new Produto(null, "Produto 45", 10.00);
		Produto p46 = new Produto(null, "Produto 46", 10.00);
		Produto p47 = new Produto(null, "Produto 47", 10.00);
		Produto p48 = new Produto(null, "Produto 48", 10.00);
		Produto p49 = new Produto(null, "Produto 49", 10.00);
		Produto p50 = new Produto(null, "Produto 50", 10.00);

		cat1.getProdutos()
				.addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27,
						p28, p29, p30, p31, p32, p34, p35, p36, p37, p38, p39, p40, p41, p42, p43, p44, p45, p46, p47,
						p48, p49, p50));

		p12.getCategorias().add(cat1);
		p13.getCategorias().add(cat1);
		p14.getCategorias().add(cat1);
		p15.getCategorias().add(cat1);
		p16.getCategorias().add(cat1);
		p17.getCategorias().add(cat1);
		p18.getCategorias().add(cat1);
		p19.getCategorias().add(cat1);
		p20.getCategorias().add(cat1);
		p21.getCategorias().add(cat1);
		p22.getCategorias().add(cat1);
		p23.getCategorias().add(cat1);
		p24.getCategorias().add(cat1);
		p25.getCategorias().add(cat1);
		p26.getCategorias().add(cat1);
		p27.getCategorias().add(cat1);
		p28.getCategorias().add(cat1);
		p29.getCategorias().add(cat1);
		p30.getCategorias().add(cat1);
		p31.getCategorias().add(cat1);
		p32.getCategorias().add(cat1);
		p33.getCategorias().add(cat1);
		p34.getCategorias().add(cat1);
		p35.getCategorias().add(cat1);
		p36.getCategorias().add(cat1);
		p37.getCategorias().add(cat1);
		p38.getCategorias().add(cat1);
		p39.getCategorias().add(cat1);
		p40.getCategorias().add(cat1);
		p41.getCategorias().add(cat1);
		p42.getCategorias().add(cat1);
		p43.getCategorias().add(cat1);
		p44.getCategorias().add(cat1);
		p45.getCategorias().add(cat1);
		p46.getCategorias().add(cat1);
		p47.getCategorias().add(cat1);
		p48.getCategorias().add(cat1);
		p49.getCategorias().add(cat1);
		p50.getCategorias().add(cat1);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat1.getProdutos().add(p1);

		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().add(cat1);

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		categoriaRepository.flush();
		produtoRepository.flush();

		produtoRepository.saveAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25,
				p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38, p39, p40, p41, p42, p43, p44, p45, p46, p47,
				p48, p49, p50));

		// categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		// produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Angola");
		Estado est2 = new Estado(null, "Moçambique");
		Estado est3 = new Estado(null, "Angola");
		Estado est4 = new Estado(null, "Moçambique");
		
		Cidade cid1 = new Cidade(null, "Luanda", est1);
		Cidade cid2 = new Cidade(null, "Maputo", est2);
		Cidade cid3 = new Cidade(null, "Luanda", est1);
		Cidade cid4 = new Cidade(null, "Maputo", est2);
		Cidade cid5 = new Cidade(null, "Cabo Delgado ", est2);

		est1.getCidades().add(cid1);
		est2.getCidades().addAll(Arrays.asList(cid2, cid3, cid4, cid5));

		estadoRepository.saveAll(Arrays.asList(est1, est2, est3, est4));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3, cid4, cid5));

		Cliente cli1 = new Cliente(null, "Nacir", "nacibraimo@gmail.com", "84337834834", TipoCliente.PESSOAFISICA,
				pwdEncoder.encode("client1"));
		cli1.getTelefones().addAll(Arrays.asList("847993530", "827993530"));

		Cliente cli2 = new Cliente(null, "Admin", "admin@email.com", "84337834834", TipoCliente.PESSOAFISICA,
				pwdEncoder.encode("root1"));
		cli2.getTelefones().addAll(Arrays.asList("867993530", "857993530"));
		cli2.addPerfil(Perfil.ADMIN);

		// Endereco e1 = new Endereco(null, "Expansao-1", "540", "Apto 30", "Bairro das
		// gordas","", cid3, cli1);

		Endereco e1 = new Endereco(null, "Expansao-1", "540", "Apto 30", "Bairro das gordas", "4753485734", cli1, cid3);
		Endereco e2 = new Endereco(null, "Av. 24 Julho", "540", "Apto 30", "Bairro das gordas", "4753485734", cli1,
				cid2);
		Endereco e3 = new Endereco(null, "Av. 25 Setembro", "992", null, "Academia Militar", "4753485734", cli2, cid2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));

		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

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
